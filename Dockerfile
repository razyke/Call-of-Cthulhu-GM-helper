FROM alpine
RUN apk add --update openjdk8
WORKDIR /app
COPY build/libs/coc-gm-helper-server-1.0-SNAPSHOT.jar /app/server.jar
EXPOSE 8080
CMD java -jar server.jar