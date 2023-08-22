FROM openjdk:17.0.2

WORKDIR /app

COPY ./target/api-exchange-rate-0.0.1-SNAPSHOT.jar .

EXPOSE 9090

ENTRYPOINT ["java","-jar","api-exchange-rate-0.0.1-SNAPSHOT.jar"]

ARG JAR_FILE=target/api-exchange-rate-0.0.1-SNAPSHOT.jar
