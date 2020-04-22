package jp.mufg.it.ee.ws.hello;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

public class HelloAsyncServiceCallbackRequestor2 {

    public static void main(String[] args) {
        System.out.println("[ HelloAsyncServiceCallbackRequestor2 ] Start");

        // サービスオブジェクトを生成する
        HelloAsyncService service = new HelloAsyncService();

        // サービスオブジェクトからSEIオブジェクトを取得する
        HelloAsyncServicePortType portType =
                service.getHelloAsyncServicePortTypePort();

        // サービスを非同期に呼び出す
        Future<?> response = portType.sayHelloAsync("Webservice", 3,
                new AsyncHandler<SayHelloResponse>() {
                    public void handleResponse(
                            Response<SayHelloResponse> response) {
                        System.out.println("[ AsyncHandler#handleResponse ] " +
                                "Start");

                        String message = null;
                        try {
                            // サービスの実行結果を受け取る
                            SayHelloResponse sayHelloResponse = response.get();
                            message = sayHelloResponse.getReturn();
                        } catch (InterruptedException ie) {
                            throw new RuntimeException(ie);
                        } catch (ExecutionException ee) {
                            throw new RuntimeException(ee);
                        }
                        System.out.println("  message ---> " + message);

                        System.out.println("[ AsyncHandler#handleResponse ] " +
                                "End");
                    }
                });

        // サービスの終了を待ちながら、その間、別の処理を続ける
        while (!response.isDone()) {
            try {
                System.out.println("  応答が返ってくるまで別の処理を続けます...");
                Thread.sleep(3000);
            } catch (InterruptedException ie) {
                throw new RuntimeException(ie);
            }
        }
        System.out.println("[ HelloAsyncServiceCallbackRequestor2 ] End");
    }
}