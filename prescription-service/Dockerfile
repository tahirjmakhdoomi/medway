FROM openjdk:11

ADD ./target/prescription-service-0.0.1-SNAPSHOT.jar /usr/src/prescription-service-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "prescription-service-0.0.1-SNAPSHOT.jar"]