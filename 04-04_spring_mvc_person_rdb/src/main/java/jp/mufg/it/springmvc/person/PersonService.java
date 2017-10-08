package jp.mufg.it.springmvc.person;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

@Component
public class PersonService {
    private EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("MyPersistenceUnit");

    public Person getPerson(Integer personId) {
        EntityManager entitiManager = emf.createEntityManager();
        return entitiManager.find(Person.class, personId);
    }

    @SuppressWarnings("unchecked")
    public List<Person> getPersonList() {
        EntityManager entitiManager = emf.createEntityManager();
        Query query = entitiManager.createQuery(
                "SELECT p FROM Person AS p");
        return query.getResultList();
    }

    public void addPerson(Person person) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction et = entityManager.getTransaction();
        et.begin();
        entityManager.persist(person);
        et.commit();
        entityManager.close();
    }

    public void removePerson(Integer personId) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction et = entityManager.getTransaction();
        et.begin();
        Person person = entityManager.find(Person.class, personId);
        entityManager.remove(person);
        et.commit();
        entityManager.close();
    }

    public void updatePerson(Person person) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction et = entityManager.getTransaction();
        et.begin();
        entityManager.merge(person);
        et.commit();
        entityManager.close();
    }
}