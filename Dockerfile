FROM openjdk:21
LABEL maintainer="javaguides.net"
ADD target/springboot-0.0.1-SNAPSHOT.jar springboot.jar
ENTRYPOINT ["java", "-jar", "springboot.jar"]