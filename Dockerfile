FROM openjdk-17.0.1
ADD /target/demo2.jar backend.jar
ENTRYPOINT ["java", "-jar", "backend.jar"]