FROM eggip/jdk:1.8

WORKDIR /root
COPY target/*.jar app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]

