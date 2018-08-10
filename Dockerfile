FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=./web/build/libs/nutracker-api-0.1.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
