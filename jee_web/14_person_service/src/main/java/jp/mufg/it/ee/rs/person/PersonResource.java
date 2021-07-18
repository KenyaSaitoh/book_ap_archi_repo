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
    private PersonMapper personMapper;

    // リソースの取得（主キー検索によるPerson取得）
    @GET
    @Path("/{personId}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson(@PathParam("personId") int personId) {
        System.out.println("[ PersonResource#getPerson ]");
        return personMapper.select(personId);
    }

    // リソースの取得（全Personリスト取得）
    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getPersonsAll() {
        System.out.println("[ PersonResource#getPersonsAll ]");
        return personMapper.selectAll();
    }

    // リソースの取得（年齢でソートして全Personリスト取得）
    @GET
    @Path("/sort_by_age")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getPersonsSortByAge(@QueryParam("isAsc")
            boolean isAsc) {
        System.out.println("[ PersonResource#getPersonsSortByAge ]");
        return personMapper.selectSortByAge(isAsc);
    }

    // リソースの作成（Personの挿入）
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Person createPerson(Person person) {
        System.out.println("[ PersonResource#createPerson ]");
        Person person2 = personMapper.insert(person);
        return person2;
    }

    // リソースの置換（Personの更新または挿入）
    @PUT
    @Path("/{personId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void replacePerson(Person person) {
        System.out.println("[ PersonResource#replacePerson ]");
        personMapper.update(person);
    }

    // リソースの削除（Personの削除）
    @DELETE
    @Path("/{personId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void removePerson(@PathParam("personId") int personId) {
        System.out.println("[ PersonResource#removePerson ]");
        personMapper.delete(personId);
    }

    // リソースの更新（年齢）
    public int updatePersonAge(Person person) {
        System.out.println("[ PersonResource#updatePersonAge ]");
        int result = personMapper.updateAge(person.getPersonId(),
                person.getAge());
        return result;
    }
}