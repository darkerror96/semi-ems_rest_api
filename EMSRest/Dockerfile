FROM openjdk:13-ea-14-jdk-alpine3.9
ADD target/EMSRest-0.0.1-SNAPSHOT.jar ems.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ems.jar"]
