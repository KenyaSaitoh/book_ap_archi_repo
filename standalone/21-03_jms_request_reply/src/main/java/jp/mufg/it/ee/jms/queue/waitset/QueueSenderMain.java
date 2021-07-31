package jp.mufg.it.ee.jms.queue.waitset;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class QueueSenderMain {

    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.put(Context.PROVIDER_URL, "tcp://localhost:61616");
        Context context = new InitialContext(props);
        QueueConnectionFactory factory = (QueueConnectionFactory)context.lookup("ConnectionFactory");
        Queue requestQueue = (Queue)context.lookup("dynamicQueues/MyRequestQueue");
        Queue replyQueue = (Queue)context.lookup("dynamicQueues/MyReplyQueue");
        QueueConnection conn = factory.createQueueConnection();
        QueueSession session = conn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

        // プロデューサを生成する
        MessageProducer producer = session.createProducer(requestQueue);

        // コンシューマを生成する
        MessageConsumer consumer = session.createConsumer(replyQueue);
        consumer.setMessageListener(new QueueListener());

        // 要求メッセージ1を生成して送信する
        TextMessage requestMessage1 = session.createTextMessage();
        requestMessage1.setText("20");
        requestMessage1.setJMSReplyTo(replyQueue); // 返送先Destinationを指定する
        SenderThread thread1 = new SenderThread(producer, consumer, requestMessage1);
        thread1.start();

        // 少し間を空ける
        try {
            Thread.sleep(3000);
        } catch(InterruptedException ie) {
        }

        // 要求メッセージ2を生成して送信する
        TextMessage requestMessage2 = session.createTextMessage();
        requestMessage2.setText("10");
        requestMessage2.setJMSReplyTo(replyQueue); // 返送先Destinationを指定する
        SenderThread thread2 = new SenderThread(producer, consumer, requestMessage2);
        thread2.start();

        // 応答メッセージの受信を開始する
        conn.start();

    }
}

/* ============================== */
class SenderThread extends Thread {

    private MessageProducer producer;
    private MessageConsumer consumer;
    private TextMessage requestMessage;

    public SenderThread(MessageProducer producer, MessageConsumer consumer,
            TextMessage requestMessage) {
        this.producer = producer;
        this.consumer = consumer;
        this.requestMessage = requestMessage;
    }

    public void run() {
        try {
            producer.send(requestMessage);
            System.out.println("##### RequestMessage #####");
            System.out.println(" RequestMessage => " + requestMessage.getText());
            String requestMessageId = requestMessage.getJMSMessageID();
            System.out.println(" JMSMessageID : " + requestMessageId);

            consumer.setMessageListener(new QueueListener());

            ReplyMessageBlockingCache replyMessageBlockingCache =
                    ReplyMessageBlockingCache.getInstance();

            TextMessage replyMessage = (TextMessage)replyMessageBlockingCache.
                    getAndWaitMessage(requestMessageId);

            // メッセージを表示する
            System.out.println("##### ReplyMessage #####");
            System.out.println(" ReplyMessage => " + replyMessage.getText());
        } catch (JMSException jmse) {
            throw new RuntimeException(jmse);
        }
    }
}

/* ============================== */
class QueueListener implements MessageListener {

    // JMSプロバイダからメッセージを受信する
    public void onMessage(Message message) {
        System.out.println("[ QueueListener#onMessage ] Start");
        TextMessage replyMessage = (TextMessage)message;
        try {
            String correlationID = replyMessage.getJMSCorrelationID();
            ReplyMessageBlockingCache replyMessageBlockingCache =
                    ReplyMessageBlockingCache.getInstance();
            replyMessageBlockingCache.putPessage(correlationID, replyMessage);
        } catch(JMSException jmse) {
        }
        System.out.println("[ QueueListener#onMessage ] End");
    }
}