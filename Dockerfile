#FROM openjdk:25-jdk-slim
#WORKDIR /app
#COPY target/server-0.0.1-SNAPSHOT.jar /app
#EXPOSE 8080
#CMD ["java", "-jar", "server-0.0.1-SNAPSHOT.jar"]



# --- Build Stage ---
FROM maven:3.9.11-eclipse-temurin-25 AS build
WORKDIR /app

# Install git for cloning the dependency
RUN apt-get update && apt-get install -y git && rm -rf /var/lib/apt/lists/*

# Clone and build the llmquestgenerator dependency
RUN git clone https://github.com/martinFrank/llmquestgenerator.git /tmp/llmquestgenerator
WORKDIR /tmp/llmquestgenerator
RUN mvn clean install

# Switch back to app directory
WORKDIR /app

# Kopiere die pom.xml und lade die Dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Kopiere den Rest der Anwendung und baue sie
COPY src ./src
RUN mvn clean package

# --- Runtime Stage ---
FROM openjdk:25-jdk-slim
WORKDIR /app

# Kopiere das gebaute JAR aus dem Build-Container
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# Starte die Anwendung
CMD ["java", "-jar", "app.jar"]
