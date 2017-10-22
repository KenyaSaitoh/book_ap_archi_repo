package jp.mufg.it.springmvc.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public Person getPerson(Integer personId) {
        return repository.getOne(personId);
    }

    public List<Person> getPersonList() {
        return repository.findAll();
    }

    public void addPerson(Person person) {
        repository.save(person);
    }

    public void removePerson(Integer personId) {
        Person person = repository.getOne(personId);
        repository.delete(person);
    }

    public void updatePerson(Person person) {
        repository.save(person);
    }
}