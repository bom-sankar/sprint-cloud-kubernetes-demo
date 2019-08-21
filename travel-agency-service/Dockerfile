FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/travel-agency-service-0.0.1-SNAPSHOT.jar travel-agency-service.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=9999 -jar /travel-agency-service.jar