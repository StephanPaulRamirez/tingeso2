FROM openjdk:17
ARG JAR_FILE=target/evaluateCredit-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} evaluateCredit-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/requestCredit-service-0.0.1-SNAPSHOT.jar"]