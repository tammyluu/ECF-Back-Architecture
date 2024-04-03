FROM maven:3-jdk-11 as builder

WORKDIR /app


COPY pom.xml .

COPY . .
RUN mvn clean package 


FROM openjdk:11

WORKDIR /app


COPY --from=builder /app/target/*.jar .


ENTRYPOINT ["java", "-jar", "Search-Suggestion-Service.jar"]

