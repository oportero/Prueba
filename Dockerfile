# Maven 
FROM maven:3.8.1-openjdk-11-slim AS builder

WORKDIR /app

COPY pom.xml .

RUN mvn -e -B dependency:resolve

RUN mvn clean -e -B package


# Usar una imagen base de Java 21
FROM openjdk:21-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR del microservicio
COPY target/BancoPichincha-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "BancoPichincha-0.0.1-SNAPSHOT.jar"]

