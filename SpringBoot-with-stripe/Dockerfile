FROM openjdk:11

ADD ./target/stripe-0.0.1-SNAPSHOT.jar /usr/src/stripe-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "stripe-0.0.1-SNAPSHOT.jar"]