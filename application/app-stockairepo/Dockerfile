FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
EXPOSE 1521
ADD application/app-stockairepo/target/stockairepo-0.0.1-SNAPSHOT.jar stockairepo-0.0.1-SNAPSHOT.jar
ADD application/app-stockairepo/script/start.sh /
RUN ["chmod", "+x", "/start.sh"]
ENTRYPOINT ["/start.sh"]