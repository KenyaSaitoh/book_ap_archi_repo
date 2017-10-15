package jp.mufg.it.ee.rs.person;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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

@Path("/persons")
public class PersonResource {

    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getPersons() {
        System.out.println("[ PersonResources#getPersons ]");
        return personList;
    }

    @GET
    @Path("/{personId}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson(@PathParam("personId") int personId) {
        System.out.println("[ PersonResources#getPerson ]");
        return personList.get(personId);
    }

    @GET
    @Path("/age_sort")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getPersonsSortByAge(@QueryParam("ageSortedByAsc")
            boolean ageSortedByAsc) {
        System.out.println("[ PersonResources#getPersonsSortByAge ]");
        System.out.println(ageSortedByAsc);
        if (ageSortedByAsc) {
            Collections.sort(personList, new PersonAgeAscComparator());
        } else {
            Collections.sort(personList, new PersonAgeDescComparator());
        }
        return personList;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Person createPerson(Person person) {
        System.out.println("[ PersonResources#createPerson ]");
        System.out.println(person);
        Integer personId = personList.size() + 1;
        person.setPersonId(personId);
        personList.add(person);
        return person;
    }

    @DELETE
    @Path("/{personId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void removePerson(@PathParam("personId") int personId) {
        System.out.println("[ PersonResources#removePerson ]");
        System.out.println(personId);
        for (Person person : personList) {
            if (person.getPersonId() == personId) {
                personList.remove(person);
            }
        }
    }

    @PUT
    @Path("/{personId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePerson(Person person) {
        System.out.println("[ PersonResources#updatePerson ]");
        System.out.println(person);
    }

    private static List<Person> personList = new CopyOnWriteArrayList<Person>();

    static {
        // Alice
        Person person1 = new Person();
        person1.setPersonId(1);
        person1.setPersonName("Alice");
        person1.setAge(25);
        person1.setGender("female");
        personList.add(person1);
        // Bob
        Person person2 = new Person();
        person2.setPersonId(2);
        person2.setPersonName("Bob");
        person2.setAge(35);
        person2.setGender("male");
        personList.add(person2);
        // Carol
        Person person3 = new Person();
        person3.setPersonId(3);
        person3.setPersonName("Carol");
        person3.setAge(30);
        person3.setGender("female");
        personList.add(person3);
    }

    static class PersonAgeAscComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            if (p1.getAge() < p2.getAge()) return 1;
            if (p1.getAge() > p2.getAge()) return -1;
            return 0;
        }
    }

    static class PersonAgeDescComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            if (p1.getAge() < p2.getAge()) return -1;
            if (p1.getAge() > p2.getAge()) return 1;
            return 0;
        }
    }
}