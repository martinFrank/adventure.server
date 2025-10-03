#FROM openjdk:25-jdk-slim
#WORKDIR /app
#COPY target/server-0.0.1-SNAPSHOT.jar /app
#EXPOSE 8080
#CMD ["java", "-jar", "server-0.0.1-SNAPSHOT.jar"]



# --- Build Stage ---
FROM maven:3.9.11-eclipse-temurin-21 AS build
WORKDIR /app

# Kopiere die pom.xml und lade die Dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Kopiere den Rest der Anwendung und baue sie
COPY src ./src
RUN mvn clean package -DskipTests

# --- Runtime Stage ---
FROM openjdk:25-jdk-slim
WORKDIR /app

# Kopiere das gebaute JAR aus dem Build-Container
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# Starte die Anwendung
CMD ["java", "-jar", "app.jar"]
