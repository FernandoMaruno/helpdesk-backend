FROM openjdk:11

WORKDIR /app

COPY ./target/*jar ./application.jar

EXPOSE 8080
