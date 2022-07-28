FROM --platform=linux/amd64 openjdk:18
VOLUME /tmp
COPY build/libs/bookshop-0.0.2-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]