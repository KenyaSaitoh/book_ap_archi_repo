package jp.mufg.it.ee.ws.hello;

import java.net.URL;
import javax.xml.namespace.QName;
import org.study.ee.ws.provider.hello.HelloService;
import org.study.ee.ws.provider.hello.HelloServicePortType;

public class HelloServiceRequestor2 {

    public static void main(String[] args) throws Exception {
        System.out.println("[ HelloServiceRequestor2 ] Start");

        // サービスオブジェクトを生成する。
        URL url = HelloServiceRequestor2.class.getClassLoader()
                .getResource("/wsdl/HelloService.wsdl");
        HelloService service = new HelloService(
                url,
                new QName("http://hello.provider.ws.ee.study.org/",
                        "HelloService"));

        // サービスオブジェクトからSEIオブジェクトを取得する。
        HelloServicePortType portType =
                service.getHelloServicePortTypePort();

        // サービスメソッドを呼び出す。
        String message = portType.sayHello("Webservice", 3);
        System.out.println("  message ---> " + message);

        System.out.println("[ HelloServiceRequestor2 ] End");
    }
}