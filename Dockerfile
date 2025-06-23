# Use official OpenJDK 17 image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy JAR file into container
COPY target/*.jar app.jar

# Expose port your app runs on (default is 8080)
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
