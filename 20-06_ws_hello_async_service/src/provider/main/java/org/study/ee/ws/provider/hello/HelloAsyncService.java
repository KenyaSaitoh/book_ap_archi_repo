package org.study.ee.ws.provider.hello;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "HelloAsyncServicePortType",
        serviceName = "HelloAsyncService")
public class HelloAsyncService {

    // サービスメソッド
    // リクエスタからは非同期に呼び出されるが、サービス実装クラスの中では
    // 非同期であることを意識しない。
    @WebMethod
    public String sayHello(String personName, int count) {
        System.out.println("[ HelloAsyncService#sayHello ] Start");

        // 終了まで15秒かかる重たい処理
        int c = 0;
        while (c < 15) {
            System.out.println("  " + c + " : サービス実行中...");
            try { Thread.sleep(1000); } catch (InterruptedException ie) {}
            c++;
        }

        String message = "Hello! 私は" + personName + "です。";
        System.out.println("[ HelloAsyncService#sayHello ] End");
        return message;
    }
}