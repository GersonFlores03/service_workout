FROM amazoncorretto:20-alpine-jdk

COPY rest-service-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["jar" , "-jar" , "app.jar"]