FROM openjdk:8-jdk-alpine as callvideoservices
EXPOSE 8080
# COPY target/*.jar /CallVideoService-0.0.1-SNAPSHOT.jar
COPY /home/gradle/source/build/libs/*.jar /CallVideoService-0.0.1-SNAPSHOT.jar
# RUN cp -a build/libs/*.jar /CallVideoService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/CallVideoService-0.0.1-SNAPSHOT.jar"]