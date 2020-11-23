FROM openjdk:11

ADD ./target/auth-service-0.0.1-SNAPSHOT.jar /usr/src/auth-service-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "auth-service-0.0.1-SNAPSHOT.jar"]
