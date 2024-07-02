# # Sử dụng hình ảnh OpenJDK làm base image
# FROM openjdk:11-jre-slim

# # Đặt biến môi trường
# ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
#     JHIPSTER_SLEEP=0 \
#     JAVA_OPTS=""

# # Tạo thư mục cho ứng dụng
# VOLUME /tmp

# # Sao chép tệp JAR từ máy chủ vào container
# COPY target/payment-service-0.0.1-SNAPSHOT.jar /app.jar

# # Chạy ứng dụng Spring Boot
# ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar"]

# Use Maven 3.9.8 with OpenJDK 17 image as a builder
FROM maven:3.9.8-openjdk-17-slim AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and download the dependencies
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copy the entire project
COPY . .

# Package the application
RUN mvn package -DskipTests

# Use a minimal JRE image for the final stage
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged application from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port the application runs on
EXPOSE 8080

# Set the entrypoint to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
