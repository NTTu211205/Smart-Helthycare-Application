# Build stage
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

COPY services/doctor-service/pom.xml .
COPY services/doctor-service/src ./src

#COPY pom.xml .
#COPY src ./src
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]

