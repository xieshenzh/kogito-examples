package org.kie.kogito.examples;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class Test {

    @ConfigProperty(name = "what.what.what")
    String message;

    private static final Logger LOGGER = LoggerFactory.getLogger(Test.class);


    void onStart(@Observes StartupEvent ev) {
        LOGGER.info(message);
    }

    void onStop(@Observes ShutdownEvent ev) {
        LOGGER.info(message);
    }
}
