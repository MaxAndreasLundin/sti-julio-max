FROM eclipse-temurin:17-jdk-alpine
ADD target/sti-julio-max-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT java -jar /app.jar