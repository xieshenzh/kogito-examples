FROM mongo:4.4

COPY launch.sh /usr/local/bin/
RUN chmod +x /usr/local/bin/launch.sh

COPY mongodb.sh /usr/local/bin/
RUN chmod +x /usr/local/bin/mongodb.sh

COPY connect.sh /usr/local/bin/
RUN chmod +x /usr/local/bin/connect.sh

COPY register-mongodb.json /usr/local/bin/
RUN chmod a=r /register-mongodb.jsonh

CMD ["bash", "-c", "/usr/local/bin/launch.sh"]