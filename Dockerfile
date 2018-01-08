FROM openjdk:8-jre-alpine

RUN mkdir /app

WORKDIR /app

ADD ./api/target/sales-api-1.0.0-SNAPSHOT.jar /app

EXPOSE 8083

CMD ["java", "-jar", "sales-api-1.0.0-SNAPSHOT.jar"]