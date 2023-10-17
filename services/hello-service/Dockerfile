FROM docker.io/maven:3.9.4 AS build

WORKDIR /hello-service

COPY pom.xml /hello-service/pom.xml
RUN ["mvn", "dependency:resolve"]

# Adding source, compile and package into a fat jar
COPY ["src/main", "/hello-service/src/main"]
RUN ["mvn", "clean", "package"]

FROM docker.io/openjdk:21-slim

COPY --from=build /hello-service/target/hello-service.jar /
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/hello-service.jar"]
EXPOSE 8888