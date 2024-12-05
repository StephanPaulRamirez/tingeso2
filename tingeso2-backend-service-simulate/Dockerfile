FROM openjdk:17
ARG JAR_FILE=target/simulate-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} simulate-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/simulate-service-0.0.1-SNAPSHOT.jar"]