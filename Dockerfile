FROM openjdk:21-jdk-slim
WORKDIR /home/app
COPY target/bartender-0.0.1-SNAPSHOT.jar /home/app/bartender.jar
CMD ["java", "-jar", "bartender.jar"]
