
FROM maven:3-jdk-11 as builder

WORKDIR /app


COPY /pom.xml .
RUN mvn  dependency:go-offline


COPY /src ./src
RUN mvn package -DskipTests


FROM openjdk:11

WORKDIR /app


COPY --from=builder /app/target/common-data-service.jar .


ENTRYPOINT ["java", "-jar", "common-data-service.jar"]

