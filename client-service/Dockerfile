FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/client-service-0.0.1-SNAPSHOT.jar client-service.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=9999 -jar /client-service.jar