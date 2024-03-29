package jp.mufg.it.ee.rs.person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonMapper {
    // 主キー検索
    public Person select(Integer personId) {
        for (Person person : personList) {
            if (person.getPersonId().equals(personId)) {
                return person;
            }
        }
        return null;
    }

    // 全件検索
    public List<Person> selectAll() {
        Collections.sort(personList, new PersonPersonIdComparator());
        dumpPersonList();
        return personList;
    }

    // 全件検索（ソート）
    public List<Person> selectSortByAge(boolean isAsc) {
        List<Person> pList = new ArrayList<Person>(personList);
        if (isAsc) {
            Collections.sort(pList, new PersonAgeAscComparator());
        } else {
            Collections.sort(pList, new PersonAgeDescComparator());
        }
        return pList;
    }

    // 条件検索（指定された年齢以上）
    public List<Person> selectByLowerAge(Integer lowerAge) {
        List<Person> pList = new ArrayList<Person>();
        for (Person person : personList) {
            if (lowerAge <= person.getAge()) {
                pList.add(person);
            }
        }
        return pList;
    }

    // 最大値取得
    public int selectMaxPersonId() {
        int maxPersonId = 0;
        for (Person person : personList) {
            if (maxPersonId < person.getPersonId()) {
                maxPersonId = person.getPersonId();
            }
        }
        return maxPersonId;
    }

    // 挿入
    public Person insert(Person person) {
        int maxPersonId = selectMaxPersonId();
        person.setPersonId(maxPersonId + 1);
        personList.add(person);
        dumpPersonList();
        return person;
    }

    // 一件削除
    public int delete(Integer personId) {
        for (Person person : personList) {
            if (person.getPersonId().equals(personId)) {
                personList.remove(person);
                dumpPersonList();
                return 1;
            }
        }
        dumpPersonList();
        return 0;
    }

    // 一件更新
    public int update(Person person) {
        for (Person p : personList) {
            if (p.getPersonId().equals(person.getPersonId())) {
                personList.remove(p);
                personList.add(person);
                dumpPersonList();
                return 1;
            }
        }
        dumpPersonList();
        return 0;
    }

    // 一括更新
    public int updateAge(Integer personId, Integer age) {
        for (Person p : personList) {
            if (p.getPersonId().equals(personId)) {
                p.setAge(age);
                dumpPersonList();
                return 1;
            }
        }
        dumpPersonList();
        return 0;
    }

    private static List<Person> personList = new CopyOnWriteArrayList<Person>();

    private static void dumpPersonList() {
        for (Person person : personList) {
            System.out.println(person);
        }
    }

    // 簡易データベース
    static {
        // Alice
        Person person1 = new Person(1, "Alice", 25, "female");
        personList.add(person1);
        // Bob
        Person person2 = new Person(2, "Bob", 35, "male");
        personList.add(person2);
        // Carol
        Person person3 = new Person(3, "Carol", 30, "female");
        personList.add(person3);
    }

    static class PersonPersonIdComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            if (p1.getPersonId() < p2.getPersonId())
                return -1;
            if (p1.getPersonId() > p2.getPersonId())
                return 1;
            return 0;
        }
    }

    static class PersonAgeAscComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            if (p1.getAge() < p2.getAge())
                return 1;
            if (p1.getAge() > p2.getAge())
                return -1;
            return 0;
        }
    }

    static class PersonAgeDescComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            if (p1.getAge() < p2.getAge())
                return -1;
            if (p1.getAge() > p2.getAge())
                return 1;
            return 0;
        }
    }
}