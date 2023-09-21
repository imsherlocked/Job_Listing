FROM openjdk:11
EXPOSE 8080
ADD target/joblisting-docker.jar joblisting-docker.jar
ENTRYPOINT ["java", "-jar", "/joblisting-docker.jar"]

