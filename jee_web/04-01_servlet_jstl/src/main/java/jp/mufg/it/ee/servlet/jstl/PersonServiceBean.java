package jp.mufg.it.ee.servlet.jstl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.CopyOnWriteArrayList;

public class PersonServiceBean {
    private static List<Person> personList;

    static  {
        personList = new CopyOnWriteArrayList<Person>();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream("persons.csv");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line;
            while ((line = br.readLine()) != null) {
                Person person = createPersonFromLine(line);
                personList.add(person);
            }
        } catch(IOException ioe) {
            throw new RuntimeException(ioe);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch(IOException ioe) {
                throw new RuntimeException(ioe);
            }
        }
    }

    public Person getPerson(Integer personId) {
        for (Person person : personList) {
            if (person.getPersonId().equals(personId)) {
                return person;
            }
        }
        return null;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void addPerson(Person person) {
        person.setPersonId(getNextPersonId());
        personList.add(person);
    }

    public void removePerson(Integer personId) {
        for (Person p : personList) {
            if (p.getPersonId().equals(personId)) {
                personList.remove(p);
                return;
            }
        }
    }

    public void updatePerson(Person person) {
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getPersonId().equals(person.getPersonId())) {
                personList.remove(i);
                personList.add(i, person);
                return;
            }
        }
        personList.add(person);
    }

    private static Person createPersonFromLine(String line) {
        StringTokenizer st = new StringTokenizer(line, ",");
        Integer personId = Integer.parseInt(st.nextToken());
        String personName = st.nextToken();
        Integer age = Integer.parseInt(st.nextToken());
        String gender = st.nextToken();
        Person person = new Person(personId, personName, age, gender);
        return person;
    }

    private Integer getNextPersonId() {
        return personList.get(personList.size() - 1).getPersonId() + 1;
    }
}