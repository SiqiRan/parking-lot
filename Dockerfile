FROM openjdk:8
ADD target/parking-lot.jar parking-lot.jar
ENTRYPOINT ["java", "-jar","parking-lot.jar"]
EXPOSE 8080