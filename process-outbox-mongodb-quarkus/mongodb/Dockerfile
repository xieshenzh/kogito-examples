FROM mongo:4.4

RUN openssl rand -base64 756 > /usr/local/bin/keyfile
RUN chown 999:999 /usr/local/bin/keyfile
RUN chmod 400 /usr/local/bin/keyfile

CMD ["mongod", "--replSet", "rs0", "--auth",  "--keyFile", "/usr/local/bin/keyfile"]
