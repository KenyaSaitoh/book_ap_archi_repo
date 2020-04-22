package jp.mufg.it.ee.jms.queue.correlation;

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

    public void putPessage(String messageId, Message message) {
        synchronized(replyMessageMap) {
            replyMessageMap.put(messageId, message);
        }
    }

    public Message getAndWaitMessage(String messageId) {
        while (true) {
            Message replyMessage = replyMessageMap.get(messageId);
            if (replyMessage != null) {
                replyMessageMap.remove(messageId);
                return replyMessage;
            }
            try {Thread.sleep(10); } catch(InterruptedException ie){};
        }
    }
}
