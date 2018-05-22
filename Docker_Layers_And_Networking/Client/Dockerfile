FROM openjdk:8-jre-alpine
RUN mkdir /var/lib/client
COPY /target/client-1.0.jar /var/lib/client
WORKDIR /var/lib/client
EXPOSE 2142
CMD ["java", "-jar", "client-1.0.jar"]