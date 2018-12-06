FROM openjdk:11-jre-slim

RUN mkdir -p /opt/app

COPY target/ort-0.0.1-SNAPSHOT.jar /opt/app/
CMD java -jar /opt/app/ort-0.0.1-SNAPSHOT.jar
