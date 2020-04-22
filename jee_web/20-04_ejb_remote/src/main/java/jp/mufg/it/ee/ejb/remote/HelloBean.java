package jp.mufg.it.ee.ejb.remote;

import javax.ejb.Stateless;

@Stateless
public class HelloBean implements Hello {

    // ビジネスメソッド
    public String sayHello(String personName) {
        System.out.println("[ HelloBean#sayHello ]");
        return "Hello " + personName + "!";
    }
}