FROM maven:3.6.0-jdk-11-slim AS build

COPY src /home/app/src

COPY pom.xml /home/app

RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/RevPay-Bank-Backend-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/usr/local/lib/demo.jar"]

#docker build -t erichdeh/revpay-bank .

#docker run --name town-container -p 8080:8080 -e RDS_URL -e RDS_USER -e RDS_PASS town-complaint