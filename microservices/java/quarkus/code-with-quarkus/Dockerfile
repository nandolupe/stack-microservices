FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/code-with-quarkus-1.0.0-SNAPSHOT-runner.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar", "$JAVA_OPTS"]
