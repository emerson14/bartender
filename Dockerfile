
FROM openjdk:21-jdk-slim

CMD ["mkdir", "/home/app/"]
# WORKDIR /app

# archivo JAR de aplicación  contenedor
ADD ./target/bartender-0.0.1-SNAPSHOT.jar /home/app/
# COPY target/bartender-0.0.1-SNAPSHOT.jar /app/bartender.jar
#  puerto en el que se ejecuta el app
EXPOSE 8080

#  comando para ejecutar tu aplicación
ENTRYPOINT ["java", "-jar", "/home/app/bartender-0.0.1-SNAPSHOT.jar"]
# ENTRYPOINT ["java", "-jar", "/app/bartender.jar"]

# ENTRYPOINT ["java", "-jar", "/home/tarjet/bartender-0.0.1-SNAPSHOT.jar"]
