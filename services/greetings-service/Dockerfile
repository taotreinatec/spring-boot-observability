FROM docker.io/maven:3.9.4 AS build

WORKDIR /greetings-service

COPY pom.xml /greetings-service/pom.xml
RUN ["mvn", "dependency:resolve"]

# Adding source, compile and package into a fat jar
COPY ["src/main", "/greetings-service/src/main"]
RUN ["mvn", "clean", "package"]

FROM docker.io/openjdk:21-slim

COPY --from=build /greetings-service/target/greetings-service.jar /
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/greetings-service.jar"]
EXPOSE 8080