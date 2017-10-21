package jp.mufg.it.ee.ws.hello;

public class HelloOnewayServiceRequestor {

    public static void main(String[] args) {
        System.out.println("[ HelloOnewayServiceRequestor ] Start");

        // サービスを生成する
        HelloOnewayService service = new HelloOnewayService();

        // サービスからサービスエンドポイントインタフェースを取得する
        HelloOnewayServicePortType portType = service
                .getHelloOnewayServicePortTypePort();

        // サービスメソッド（一方向型）を呼び出す
        portType.sayHello("Webservice", 3);

        System.out.println("[ HelloOnewayServiceRequestor ] End");
    }
}