package jp.mufg.it.ee.ejb.async;

import java.util.Random;

public class ThreadUtil {

    public static void sleepAWhile(long time) {
        try {
            Thread.sleep(time);
        } catch(InterruptedException ie) {
            throw new RuntimeException(ie);
        }
    }

    public static void sleepRandomTime(long from, long to) {
        Random random = new Random();
        long sleepTime = from + random.nextInt((int)to - (int)from);
        try {
            Thread.sleep(sleepTime);
        } catch(InterruptedException ie) {
            throw new RuntimeException(ie);
        }
    }
}