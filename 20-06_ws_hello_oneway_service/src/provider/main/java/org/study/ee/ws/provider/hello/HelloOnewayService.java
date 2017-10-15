package org.study.ee.ws.provider.hello;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "HelloOnewayServicePortType",
        serviceName = "HelloOnewayService")
public class HelloOnewayService {

    // サービスメソッド（一方向型）
    @WebMethod
    @Oneway
    public void sayHello(String personName, int count) {
        System.out.println("[ HelloOnewayService#sayHello ] Start");

        // 終了まで15秒かかる重たい処理
        int c = 0;
        while (c < 15) {
            System.out.println("  " + c + " : サービス実行中...");
            try { Thread.sleep(1000); } catch (InterruptedException ie) {}
            c++;
        }

        System.out.println("[ HelloOnewayService#sayHello ] End");
    }
}