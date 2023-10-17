FROM docker.io/maven:3.9.4 AS build

WORKDIR /fortune-service

COPY pom.xml /fortune-service/pom.xml

COPY ["src/main", "/fortune-service/src/main"]
RUN ["mvn", "clean", "package"]

FROM docker.io/openjdk:21-slim

COPY --from=build /fortune-service/target/fortune-service.jar /
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/fortune-service.jar"]
EXPOSE 8888