# --- Build Stage ---
FROM amazoncorretto:25-alpine as build
WORKDIR /app

# Install git for cloning the dependency
RUN apk add --no-cache git
RUN apk add --no-cache maven

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
FROM amazoncorretto:25-alpine
WORKDIR /app

# Kopiere das gebaute JAR aus dem Build-Container
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# Starte die Anwendung
CMD ["java", "-jar", "app.jar"]
