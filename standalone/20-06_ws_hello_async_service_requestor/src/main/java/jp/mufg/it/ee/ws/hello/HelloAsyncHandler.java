package jp.mufg.it.ee.ws.hello;

import java.util.concurrent.ExecutionException;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

public class HelloAsyncHandler implements AsyncHandler<SayHelloResponse> {

    public void handleResponse(Response<SayHelloResponse> response) {
        System.out.println("[ HelloAsyncHandler#handleResponse ] Start");

        String message = null;
        try {
            // サービスの実行結果を受け取る（③）
            SayHelloResponse sayHelloResponse = response.get();
            message = sayHelloResponse.getReturn();
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        } catch (ExecutionException ee) {
            throw new RuntimeException(ee);
        }
        System.out.println("  message ---> " + message);

        System.out.println("[ HelloAsyncHandler#handleResponse ] End");
    }
}
