# Use the official OpenJDK image from Docker Hub
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target folder into the container
COPY target/eureka-server-*.jar app.jar

# Expose port 8761 (default Eureka port)
EXPOSE 8761

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
