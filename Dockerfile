FROM amazoncorretto:17

# Set the working directory inside the container
WORKDIR /todo-app

# Copy your application JAR or files into the container
COPY target/todo-app-1.0.0-SNAPSHOT.jar /app/

EXPOSE 8080

# Specify the command to run your application
CMD ["java", "-jar", "todo-app-1.0.0-SNAPSHOT.jar"]