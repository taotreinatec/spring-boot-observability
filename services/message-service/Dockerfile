FROM docker.io/maven:3.9.4 AS build

WORKDIR /message-service

COPY pom.xml /message-service/pom.xml
RUN ["mvn", "dependency:resolve"]

# Adding source, compile and package into a fat jar
COPY ["src/main", "/message-service/src/main"]
RUN ["mvn", "clean", "package"]

FROM docker.io/openjdk:21-slim

COPY --from=build /message-service/target/message-service.jar /
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/message-service.jar"]
EXPOSE 8888