package jp.mufg.it.springmvc.person;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class PersonService {
    @PersistenceContext
    private EntityManager entityManager;

    public Person getPerson(Integer personId) {
        return entityManager.find(Person.class, personId);
    }

    @SuppressWarnings("unchecked")
    public List<Person> getPersonList() {
        Query query = entityManager.createQuery(
                "SELECT p FROM Person AS p");
        return query.getResultList();
    }

    public void addPerson(Person person) {
        entityManager.persist(person);
    }

    public void removePerson(Integer personId) {
        Person person = entityManager.find(Person.class, personId);
        entityManager.remove(person);
    }

    public void updatePerson(Person person) {
        entityManager.merge(person);
    }
}