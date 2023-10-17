FROM docker.io/maven:3.9.4 AS build

WORKDIR /name-service

COPY pom.xml /name-service/pom.xml

COPY ["src/main", "/name-service/src/main"]
RUN ["mvn", "clean", "package"]

FROM docker.io/openjdk:21-slim

COPY --from=build /name-service/target/name-service.jar /
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/name-service.jar"]
EXPOSE 8888