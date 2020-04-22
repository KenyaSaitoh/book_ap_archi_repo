package jp.mufg.it.ee.rs.greeting;

import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/greeting")
public class GreetingResource {

    @GET
    @Path("/hello/{personName}")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(@PathParam("personName") String personName) {
        return "Hello " + personName + "!";
    }

    @GET
    @Path("/goodbye/{personName}")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayGoodbye(@PathParam("personName") String personName) {
        return "Goodbye " + personName + "!";
    }

    @GET
    @Path("/morning")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayGoodMorning(@QueryParam("personName") String personName) {
        return "Good Morning " + personName + "!";
    }

    @POST
    @Path("/afternoon")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayGoodAfternoon(@FormParam("personName") String personName) {
        return "Good Afternoon " + personName + "!";
    }

    @GET
    @Path("/night")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayGoodNight(@HeaderParam("personName") String personName) {
        return "Good Night " + personName + "!";
    }

    @GET
    @Path("/evening")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayGoodEvening(@CookieParam("personName") String personName) {
        return "Good Evening " + personName + "!";
    }
}