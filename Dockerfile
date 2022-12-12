FROM openjdk:17-jdk-slim

RUN mkdir -p /opt/app

ENV PROJECT_HOME /opt/app

COPY ./target/ChallengeFoh-0.0.1-SNAPSHOT.jar $PROJECT_HOME/app.jar

WORKDIR $PROJECT_HOME

CMD ["java","-jar","./app.jar"]