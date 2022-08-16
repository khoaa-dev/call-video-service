# temp container to build using gradle
FROM gradle:7.5-jdk8 as gradleimage
COPY . /home/gradle/source
WORKDIR /home/gradle/source
RUN gradle init && gradle build