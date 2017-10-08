package jp.mufg.it.ee.jsf.person;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

@RequestScoped
@Transactional(TxType.REQUIRED)
public class PersonService {
    @PersistenceContext(unitName = "MyPersistenceUnit")
    private EntityManager entitiManager;

    public Person getPerson(Integer personId) {
        return entitiManager.find(Person.class, personId);
    }

    @SuppressWarnings("unchecked")
    public List<Person> getPersonList() {
        Query query = entitiManager.createQuery(
                "SELECT p FROM Person AS p");
        return query.getResultList();
    }

    public void addPerson(Person person) {
        entitiManager.persist(person);
    }

    public void removePerson(Integer personId) {
        Person person = entitiManager.find(Person.class, personId);
        entitiManager.remove(person);
    }

    public void updatePerson(Person person) {
        entitiManager.merge(person);
    }
}