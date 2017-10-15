package org.study.ee.ws.requestor.hello;

public class DeamonThread extends Thread {
    public void run() {
        try {
            Thread.sleep(20000);
        } catch(InterruptedException ie) {
        }
    }
}
