FROM openjdk:11

ADD ./target/Medicine-Service-0.0.1-SNAPSHOT.jar /usr/src/Medicine-Service-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "Medicine-Service-0.0.1-SNAPSHOT.jar"]