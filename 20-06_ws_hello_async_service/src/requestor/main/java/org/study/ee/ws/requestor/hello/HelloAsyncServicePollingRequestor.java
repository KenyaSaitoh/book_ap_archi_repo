package org.study.ee.ws.requestor.hello;

import java.util.concurrent.ExecutionException;
import javax.xml.ws.Response;
import org.study.ee.ws.provider.hello.HelloAsyncService;
import org.study.ee.ws.provider.hello.HelloAsyncServicePortType;
import org.study.ee.ws.provider.hello.SayHelloResponse;

public class HelloAsyncServicePollingRequestor {

    public static void main(String[] args) {
        System.out.println("[ HelloAsyncServicePollingRequestor ] Start");

        // サービスオブジェクトを生成する。
        HelloAsyncService service = new HelloAsyncService();

        // サービスオブジェクトからSEIオブジェクトを取得する。
        HelloAsyncServicePortType portType =
                service.getHelloAsyncServicePortTypePort();

        // サービスを非同期に呼び出す。（①）
        Response<SayHelloResponse> response =
                portType.sayHelloAsync("Webservice", 3);

        // サービスの終了を待ちながら、その間、別の処理を続ける。（②）
        while (!response.isDone()) {
            try {
                System.out.println("  応答が返ってくるまで別の処理を続けます...");
                Thread.sleep(3000);
            } catch (InterruptedException ie) {
                throw new RuntimeException(ie);
            }
        }

        String message = null;
        try {
            // サービスの実行結果を受け取る。（③）
            SayHelloResponse sayHelloResponse = response.get();
            message = sayHelloResponse.getReturn();
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        } catch (ExecutionException ee) {
            throw new RuntimeException(ee);
        }
        System.out.println("  message ---> " + message);

        System.out.println("[ HelloAsyncServicePollingRequestor ] End");
    }
}