FROM swd847/centos-graal-native-image-rc12 as nativebuilder
ARG JAR_FILE
COPY /target /project/
WORKDIR /project
RUN  /opt/graalvm/bin/native-image -J-Djava.util.logging.manager=org.jboss.logmanager.LogManager \
     -J-Dcom.sun.xml.internal.bind.v2.bytecode.ClassTailor.noOptimize=true \
     -H:InitialCollectionPolicy='com.oracle.svm.core.genscavenge.CollectionPolicy$BySpaceAndTime' \
     -jar ${JAR_FILE}.jar -J-Djava.util.concurrent.ForkJoinPool.common.parallelism=1 \
     -H:+PrintAnalysisCallTree -H:EnableURLProtocols=http \
     -H:-SpawnIsolates -H:-JNI --no-server -H:-UseServiceLoaderFeature -H:+StackTrace \
     && cp  -v ${JAR_FILE} /tmp/quarkus-knative-runner

FROM  registry.fedoraproject.org/fedora-minimal
RUN mkdir -p /work
COPY --from=nativebuilder /tmp/quarkus-knative-runner /work/application
RUN chmod -R 775 /work
EXPOSE 8080
WORKDIR /work/
ENTRYPOINT ["./application","-Dquarkus.http.host=0.0.0.0"]