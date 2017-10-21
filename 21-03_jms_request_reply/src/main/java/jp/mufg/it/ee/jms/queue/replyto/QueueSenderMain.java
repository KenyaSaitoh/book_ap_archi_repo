package jp.mufg.it.ee.jms.queue.replyto;

import java.util.Properties;

import javax.jms.MessageConsumer;
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
        QueueConnectionFactory factory = (QueueConnectionFactory)context
                .lookup("ConnectionFactory");
        Queue requestQueue = (Queue)context.lookup("dynamicQueues/MyRequestQueue");
        Queue replyQueue = (Queue)context.lookup("dynamicQueues/MyReplyQueue");
        QueueConnection conn = factory.createQueueConnection();
        QueueSession session = conn.createQueueSession(false,
                Session.AUTO_ACKNOWLEDGE);

        // プロデューサを生成する
        MessageProducer producer = session.createProducer(requestQueue);

        // 要求メッセージを生成する
        TextMessage requestMessage = session.createTextMessage();
        requestMessage.setText("Foo");
        requestMessage.setJMSReplyTo(replyQueue); // 返送先Destinationを指定する

        // 要求メッセージを送信する
        producer.send(requestMessage);
        System.out.println("===== RequestMessage =====");
        System.out.println(" RequestMessage ---> " + requestMessage.getText());
        String requestMessageId = requestMessage.getJMSMessageID();
        System.out.println(" JMSMessageID : " + requestMessageId);

        // メッセージコンシューマを生成する
        MessageConsumer consumer = session.createConsumer(replyQueue);

        // 応答メッセージの受信を開始する
        conn.start();

        // 応答メッセージを待つ（ブロック）
        TextMessage replyMessage = (TextMessage)consumer.receive();
        String correlationID = replyMessage.getJMSCorrelationID();
        System.out.println("===== ReplyMessage =====");
        System.out.println(" ReplyMessage ---> " + replyMessage.getText());
        System.out.println(" JMSCorrelationID : " + correlationID);

        // メッセージの受信を停止する
        conn.close();
    }
}