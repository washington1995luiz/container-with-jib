# Etapa de build com Java 23 e instalação do Maven
FROM eclipse-temurin:23-jdk AS build
WORKDIR /app

# Instala o Maven manualmente
RUN apt-get update && apt-get install -y maven

COPY /src /app/src
COPY /pom.xml /app
RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip

# Imagem final apenas com a JRE para rodar a aplicação
FROM eclipse-temurin:23-jre
EXPOSE 80
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
