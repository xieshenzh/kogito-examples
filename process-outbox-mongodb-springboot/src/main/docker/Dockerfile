FROM registry.access.redhat.com/ubi8/openjdk-11-runtime

VOLUME /tmp

ARG JAR_FILE=target/*-springboot.jar
COPY ${JAR_FILE} /app.jar

ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app.jar ${0} ${@}"]