package org.quarkus.quickstart;

import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.drools.core.RuleBaseConfiguration;
import org.drools.core.impl.KnowledgeBaseImpl;
import org.kie.dmn.api.core.DMNContext;
import org.kie.dmn.api.core.DMNMessage;
import org.kie.dmn.api.core.DMNModel;
import org.kie.dmn.api.core.DMNResult;
import org.kie.dmn.api.core.DMNRuntime;
import org.kie.dmn.core.compiler.DMNCompilerImpl;
import org.kie.dmn.core.impl.DMNRuntimeImpl;

@Path("/dmn")
public class DMNResource {

    static final DMNRuntime dmnRuntime = new DMNRuntimeImpl(new KnowledgeBaseImpl("", new RuleBaseConfiguration()));
    static final DMNModel dmnModel;
    static {
        InputStream is = DMNResource.class.getResourceAsStream("/greetings.dmn");
        DMNCompilerImpl compilerImpl = new DMNCompilerImpl();
        dmnModel = compilerImpl.compile(new InputStreamReader(is));
    }
    //    static final DMNModel dmnModel2;
    //    static {
    //        InputStream is = DMNResource.class.getResourceAsStream("/adult.dmn");
    //        DMNCompilerImpl compilerImpl = new DMNCompilerImpl();
    //        dmnModel2 = compilerImpl.compile(new InputStreamReader(is));
    //    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/dmn/{name}")
    public String dmn(@PathParam("name") String name) {
        DMNContext ctx = dmnRuntime.newContext();
        ctx.set("a name", name);
        DMNResult evaluateAll = dmnRuntime.evaluateAll(dmnModel, ctx);
        for (DMNMessage m : evaluateAll.getMessages()) {
            System.out.println(m);
        }
        return evaluateAll.toString();
    }

    //    @GET
    //    @Produces(MediaType.TEXT_PLAIN)
    //    @Path("/dmn2/{name}")
    //    public String dmn2(@PathParam("name") String name) {
    //        DMNContext ctx = dmnRuntime.newContext();
    //        ctx.set("a number", Long.valueOf(name));
    //        DMNResult evaluateAll = dmnRuntime.evaluateAll(dmnModel2, ctx);
    //        for (DMNMessage m : evaluateAll.getMessages()) {
    //            System.out.println(m);
    //        }
    //        return evaluateAll.toString();
    //    }
}
