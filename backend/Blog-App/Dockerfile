# Stage 1: Build
# ARG MAVEN_VERSION=3.8
FROM maven:$MAVEN_VERSION-jdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src src
COPY mvnw .
COPY .mvn .
RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests

# Stage 2: Final Image
FROM openjdk:17-jdk
VOLUME /tmp
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080
