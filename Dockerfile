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
