package jp.mufg.it.ee.servlet.mvc;

public class PersonLogic {
    public String sayHello(String personName, String country) {
        if (country != null && country.equals("japan")) {
            return "こんにちは！私は" + personName + "です";
        } else {
            return "Hello! I'm " + personName + ".";
        }
    }
}