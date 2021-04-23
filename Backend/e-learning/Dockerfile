FROM openjdk:14

RUN mkdir /docker

WORKDIR /docker

COPY . . 

EXPOSE 8080


ENTRYPOINT ["java", "-jar", "e-learning.jar"]

