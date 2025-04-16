FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/Analytics-*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]