FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} product.jar
ENTRYPOINT ["java","-jar","/product.jar"]