FROM openjdk:17
ARG JAR_FILE=target/register-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} register-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/register-service-0.0.1-SNAPSHOT.jar"]