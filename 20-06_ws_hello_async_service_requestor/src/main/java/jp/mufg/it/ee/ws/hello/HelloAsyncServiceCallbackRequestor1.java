package jp.mufg.it.ee.ws.hello;

import java.util.concurrent.Future;

public class HelloAsyncServiceCallbackRequestor1 {

    public static void main(String[] args) {
        System.out.println("[ HelloAsyncServiceCallbackRequestor1 ] Start");

        // サービスオブジェクトを生成する
        HelloAsyncService service = new HelloAsyncService();

        // サービスオブジェクトからSEIオブジェクトを取得する
        HelloAsyncServicePortType portType =
                service.getHelloAsyncServicePortTypePort();

        @SuppressWarnings("unused")
        Future<?> response =
                portType.sayHelloAsync("Webservice", 3, new HelloAsyncHandler());

        /*
         * コールバックのリスンスレッドは、デーモンスレッドとして起動される。
         * 従って、メインスレッドが終了してしまうと、デーモンスレッドも消滅し、
         * リスンも終了してしまう。
         * ダミーの非デーモンスレッドを立ち上げておけば、リスンし続けることが
         * できる。
         */

        Thread.currentThread().setDaemon(false);
        //DeamonThread deamon = new DeamonThread();
        //deamon.setDaemon(false);
        //deamon.start();

        /*
         * 以下のようにして、応答が返ってくるまで別の処理を続けてもよい。
        while (!response.isDone()) {
            try {
                System.out.println("応答が返ってくるまで別の処理を続けます...");
                Thread.sleep(3000);
            } catch (InterruptedException ie) {
                throw new RuntimeException(ie);
            }
        }
        */

        System.out.println("[ HelloAsyncServiceCallbackRequestor1 ] End");
    }
}