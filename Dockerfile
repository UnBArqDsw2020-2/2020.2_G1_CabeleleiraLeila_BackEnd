FROM maven:3.6.3-openjdk-11-slim
RUN mkdir /data
WORKDIR /data
CMD ["sh", "mvnw", "spring-boot:run"]
