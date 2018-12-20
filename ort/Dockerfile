FROM openjdk:11-jre-slim

RUN mkdir -p /opt/app

COPY target/ort-0.0.1-SNAPSHOT.jar /opt/app/
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/app/ort-0.0.1-SNAPSHOT.jar"]
