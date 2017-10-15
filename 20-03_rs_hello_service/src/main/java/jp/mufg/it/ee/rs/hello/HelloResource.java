package jp.mufg.it.ee.rs.hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")
public class HelloResource {

    @GET
    @Path("/jaxrs")
    @Produces("text/plain")
    public String sayHello() {
        return "Hello JAX-RS!";
    }
}