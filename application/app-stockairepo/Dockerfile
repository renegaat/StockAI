FROM java:8
VOLUME /tmp
EXPOSE 8080
EXPOSE 1521
ADD target/stockairepo-0.0.1-SNAPSHOT.jar stockairepo-0.0.1-SNAPSHOT.jar
ADD script/start.sh /
RUN ["chmod", "+x", "/start.sh"]
ENTRYPOINT ["/start.sh"]