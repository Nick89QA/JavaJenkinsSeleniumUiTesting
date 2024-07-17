
FROM maven:3.8.5-openjdk-11-slim AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY . .

RUN mvn clean install

FROM openjdk:11-jre-slim

WORKDIR /app

COPY --from=build /app/target /app/target

CMD ["java", "-jar", "target/your-app.jar"]

