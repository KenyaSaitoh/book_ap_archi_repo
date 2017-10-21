package jp.mufg.it.ee.ws.hello;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "HelloServicePortType",
        serviceName = "HelloService")
public class HelloService {

    // サービスメソッド
    @WebMethod
    public String sayHello(String personName, int count) {
        System.out.println("[ HelloService#sayHello ] Start");

        String message = "Hello! 私は" + personName + "です";
        for (int i = 0; i < count; i++) {
            System.out.println("  " + i + " : message ---> " + message);
        }

        System.out.println("[ HelloService#sayHello ] End");
        return message;
    }
}