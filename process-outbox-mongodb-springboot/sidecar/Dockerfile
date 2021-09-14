FROM registry.access.redhat.com/ubi8/ubi-minimal:8.3

COPY launch.sh /usr/local/bin/
RUN chmod +x /usr/local/bin/launch.sh

CMD ["bash", "-c", "/usr/local/bin/launch.sh"]