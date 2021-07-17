package jp.mufg.it.ee.rs.person;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/persons")
public class PersonResource {

    // インジェクションポイント
    @Inject
    private PersonRepository personRepository;

    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getPersons() {
        System.out.println("[ PersonResources#getPersons ]");
        return personRepository.selectAll();
    }

    @GET
    @Path("/{personId}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson(@PathParam("personId") int personId) {
        System.out.println("[ PersonResources#getPerson ]");
        return personRepository.select(personId);
    }

    @GET
    @Path("/sort_by_age")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getPersonsSortByAge(@QueryParam("isAsc")
            boolean isAsc) {
        System.out.println("[ PersonResources#getPersonsSortByAge ]");
        return personRepository.selectSortByAge(isAsc);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Person createPerson(Person person) {
        System.out.println("[ PersonResources#createPerson ]");
        Person person2 = personRepository.insert(person);
        return person2;
    }

    @DELETE
    @Path("/{personId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void removePerson(@PathParam("personId") int personId) {
        System.out.println("[ PersonResources#removePerson ]");
        personRepository.delete(personId);
    }

    @PUT
    @Path("/{personId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void replacePerson(Person person) {
        System.out.println("[ PersonResources#replacePerson ]");
        personRepository.update(person);
    }
}