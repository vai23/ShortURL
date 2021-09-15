FROM openjdk:16-alpine3.13
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} shorturl_app.jar
VOLUME /tmp
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/shorturl_app.jar"]
