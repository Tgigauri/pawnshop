FROM openjdk:19-oracle
WORKDIR /app
COPY /target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]