FROM openjdk:17.0.2-jdk
MAINTAINER calderon200396@gmail.com
VOLUME /tmp
EXPOSE 9090
ARG JAR_FILE=target/api-exchange-rate-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar","/app.jar"]
