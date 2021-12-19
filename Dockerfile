FROM openjdk:8-jdk-alpine as build
WORKDIR /app
COPY target/*.jar target/
RUN mkdir -p target/extracted
RUN java -Djarmode=layertools -jar target/*.jar extract --destination target/extracted

FROM openjdk:8-jdk-alpine
WORKDIR /app
ARG EXTRACTED=/app/target/extracted
COPY --from=build ${EXTRACTED}/dependencies/ ./
COPY --from=build ${EXTRACTED}/spring-boot-loader/ ./
COPY --from=build ${EXTRACTED}/snapshot-dependencies/ ./
COPY --from=build ${EXTRACTED}/application/ ./
ENTRYPOINT ["java","org.springframework.boot.loader.JarLauncher"]