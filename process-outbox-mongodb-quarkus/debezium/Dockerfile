FROM debezium/connect:1.7

USER root

COPY connect.sh /
RUN chmod +x /connect.sh

COPY register-mongodb.json /
RUN chmod a=r /register-mongodb.json

COPY launch.sh /
RUN chmod +x /launch.sh

USER kafka

ENTRYPOINT []
CMD ["bash", "-c", "/launch.sh"]
