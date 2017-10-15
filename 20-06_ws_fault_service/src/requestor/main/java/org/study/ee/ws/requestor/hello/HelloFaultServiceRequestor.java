package org.study.ee.ws.requestor.hello;

import org.study.ee.ws.provider.hello.FooException;
import org.study.ee.ws.provider.hello.FooException_Exception;
import org.study.ee.ws.provider.hello.HelloFaultService;
import org.study.ee.ws.provider.hello.HelloFaultServicePortType;

public class HelloFaultServiceRequestor {

    public static void main(String[] args) {
        System.out.println("[ HelloFaultServiceRequestor ] Start");

        // サービスオブジェクトを生成する。
        HelloFaultService service = new HelloFaultService();

        // サービスオブジェクトからSEIオブジェクトを取得する。
        HelloFaultServicePortType portType =
                service.getHelloFaultServicePortTypePort();

        // サービスメソッドを呼び出す。
        try {
            portType.sayHello("Webservice", 3);
        } catch(FooException_Exception fe) {
            FooException foo = fe.getFaultInfo();
            System.out.println(foo.getMessage());
        }

        System.out.println("[ HelloFaultServiceRequestor ] End");
    }
}