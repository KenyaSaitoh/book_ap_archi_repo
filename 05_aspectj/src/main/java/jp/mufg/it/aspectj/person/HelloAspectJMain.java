package jp.mufg.it.aspectj.person;

public class HelloAspectJMain {

    public static void main(String[] params) {
        Person person = new Person("John Lennon", 35, "male");
        Integer age = person.getAge();
        person.setAge(age + 1);
        person.sayHello();
    }
}