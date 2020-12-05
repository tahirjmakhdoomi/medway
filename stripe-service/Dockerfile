FROM openjdk:11

ADD ./target/stripe-service-0.0.1-SNAPSHOT.jar /usr/src/stripe-service-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "stripe-service-0.0.1-SNAPSHOT.jar"]
