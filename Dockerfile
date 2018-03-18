FROM java:8
VOLUME ["/tmp"]
RUN mkdir /springbootdocker
WORKDIR /springbootdocker
COPY target/springboot*.jar /springbootdocker/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/springbootdocker/app.jar"]
