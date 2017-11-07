FROM openjdk:8-jdk-alpine
COPY . /data/www
ADD target/player-1.0.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar