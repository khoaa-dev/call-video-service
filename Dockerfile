FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} call-video-service.jar
ENTRYPOINT ["java","-jar","/call-video-service.jar"]