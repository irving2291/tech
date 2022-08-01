FROM openjdk:18-jdk-alpine
COPY /target/tech-0.0.1-SNAPSHOT.jar tech-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/tech-0.0.1-SNAPSHOT.jar"]
