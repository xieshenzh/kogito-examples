FROM mongo:4.4

LABEL maintainer="Debezium Community"

COPY launch.sh /usr/local/bin/
RUN chmod +x /usr/local/bin/launch.sh

COPY init-kogito.sh /usr/local/bin/
RUN chmod +x /usr/local/bin/init-kogito.sh

RUN openssl rand -base64 756 > /usr/local/bin/keyfile
RUN chown 999:999 /usr/local/bin/keyfile
RUN chmod 400 /usr/local/bin/keyfile

CMD ["bash", "-c", "/usr/local/bin/launch.sh"]
