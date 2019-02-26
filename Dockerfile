FROM openjdk:11-jre-slim

COPY target/ungewoehnlicher-aufenthaltsort-0.0.1-SNAPSHOT.jar /app.jar

EXPOSE 45222

CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=prod", "/app.jar"]