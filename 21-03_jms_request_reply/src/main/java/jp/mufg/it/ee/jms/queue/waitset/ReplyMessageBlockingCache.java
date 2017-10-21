package jp.mufg.it.ee.jms.queue.waitset;

import java.util.HashMap;
import java.util.Map;

import javax.jms.Message;

public class ReplyMessageBlockingCache {
    private static ReplyMessageBlockingCache replyMessageBlockingCache =
            new ReplyMessageBlockingCache();

    private ReplyMessageBlockingCache() {};

    public static ReplyMessageBlockingCache getInstance() {
        return replyMessageBlockingCache;
    }

    private Map<String, Message> replyMessageMap = new HashMap<>();

    public synchronized void putPessage(String messageId, Message message) {
        replyMessageMap.put(messageId, message);
        System.out.println("[ ReplyMessageBlockingCache#notifyAll ]");
        notifyAll();
    }

    public synchronized Message getAndWaitMessage(String messageId) {
        while (true) {
            try {
                System.out.println("[ ReplyMessageBlockingCache#wait ] Start");
                wait();
            } catch(InterruptedException ie) {
                throw new RuntimeException(ie);
            }
            System.out.println("[ ReplyMessageBlockingCache#wait ] End");
            Message replyMessage = replyMessageMap.get(messageId);
            if (replyMessage != null) {
                replyMessageMap.remove(messageId);
                return replyMessage;
            }
        }
    }
}
