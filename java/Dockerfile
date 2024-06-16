FROM maven:3.9.6-amazoncorretto-21-debian as appBuilder
WORKDIR /opt/app
COPY . .

RUN mvn clean install -DskipTests

FROM azul/zulu-openjdk-alpine:21-jre

RUN addgroup -S appgroup && adduser -S appuser -G appgroup

COPY --chown=appuser:appgroup --from=appBuilder /opt/app/target/stroeerKata.jar app.jar

USER appuser
WORKDIR /opt/app

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]
