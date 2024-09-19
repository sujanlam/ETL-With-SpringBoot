FROM openjdk:8
EXPOSE 8080
ADD target/etl-with-springboot.jar /etl-with-springboot.jar
ENTRYPOINT ["java", "-jar", "/etl-with-springboot,jar"]