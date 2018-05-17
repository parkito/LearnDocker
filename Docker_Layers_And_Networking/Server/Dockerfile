FROM openjdk:8-jre-alpine
RUN mkdir /var/lib/server
COPY /target/server-1.0.jar /var/lib/server
WORKDIR /var/lib/server
EXPOSE 2141
CMD ["java", "-jar", "server-1.0.jar"]