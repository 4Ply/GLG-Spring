FROM java:openjdk-8-jre-alpine

WORKDIR /data

EXPOSE 2533

COPY target/GLG-Spring-1.3-SNAPSHOT.jar /data/

CMD ["java", "-jar", "GLG-Spring-1.3-SNAPSHOT.jar"]
