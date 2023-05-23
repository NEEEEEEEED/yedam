FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENV TZ=Asia/Seoul

ENV SPRING_PROFILES_ACTIVE=linux
ENTRYPOINT ["java","-jar","/app.jar"]


