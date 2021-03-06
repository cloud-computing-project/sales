package rso.projects.sales.api.v1.resources;

import com.kumuluz.ee.common.runtime.EeRuntime;
import rso.projects.sales.api.v1.configuration.RestProperties;
import com.kumuluz.ee.logs.cdi.Log;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@Path("demo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Log
public class DemoResource {

    private Logger log = Logger.getLogger(DemoResource.class.getName());

    @Inject
    private RestProperties restProperties;

    @GET
    @Path("instanceid")
    public Response getInstanceId() {

        String instanceId =
                "{\"instanceId\" : \"" + EeRuntime.getInstance().getInstanceId() + "\"}";

        return Response.ok(instanceId).build();
    }

    @POST
    @Path("load")
    public Response loadSale(Integer n) {

        for (int i = 1; i <= n; i++) {
            fibonacci(i);
        }

        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("healthy")
    @Consumes("application/json")
    public Response setHealth(Boolean healthy) {
        restProperties.setHealthy(healthy);
        log.info("Setting health to " + healthy);
        return Response.ok().build();
    }

    @GET
    @Path("healthy")
    public Boolean getHealth() {
        return restProperties.isHealthy();
    }

    @GET
    @Path("configVar")
    public Boolean getVariable() {
        return restProperties.isSaleServiceEnabled();
    }

    @GET
    @Path("testVar")
    public Boolean getTestVariable() {
        return restProperties.isTest();
    }

    private long fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
