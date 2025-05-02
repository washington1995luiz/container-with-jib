#FROM maven:3.9.9-eclipse-temurin-21-alpine AS build
#WORKDIR /app
#COPY /src /app/src
#COPY /pom.xml /app
#RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip

FROM maven:3.9.4-amazoncorretto-21
EXPOSE 80
#COPY --from=build /app/target/*.jar app.jar
COPY /target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]