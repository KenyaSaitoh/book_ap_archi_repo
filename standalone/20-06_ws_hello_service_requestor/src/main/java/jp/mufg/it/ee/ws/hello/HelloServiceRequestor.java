package jp.mufg.it.ee.ws.hello;

public class HelloServiceRequestor {

    public static void main(String[] args) {
        System.out.println("[ HelloServiceRequestor ] Start");

        // サービスオブジェクトを生成する
        HelloService service = new HelloService();

        // サービスオブジェクトからSEIオブジェクトを取得する
        HelloServicePortType portType =
                service.getHelloServicePortTypePort();

        // サービスメソッドを呼び出す
        String message = portType.sayHello("Webservice", 3);
        System.out.println("  message => " + message);

        System.out.println("[ HelloServiceRequestor ] End");
    }
}