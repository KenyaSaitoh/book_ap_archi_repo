package jp.mufg.it.ee.jms.queue.correlation;

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

public class QueueReceiverMain {

    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.put(Context.PROVIDER_URL, "tcp://localhost:61616");
        Context context = new InitialContext(props);
        QueueConnectionFactory factory = (QueueConnectionFactory)context
                .lookup("ConnectionFactory");
        Queue requestQueue = (Queue)context
                .lookup("dynamicQueues/MyRequestQueue");
        QueueConnection conn = factory.createQueueConnection();
        QueueSession session = conn.createQueueSession(false,
                Session.AUTO_ACKNOWLEDGE);

        // コンシューマを生成する
        MessageConsumer consumer = session.createConsumer(requestQueue);

        // メッセージの受信を開始する
        conn.start();
        while (true) {
            // 要求メッセージを取得する（ブロックされる）
            TextMessage requestMessage = (TextMessage)consumer.receive();

            // 要求メッセージのテキストを取得する
            String text = requestMessage.getText();

            // 要求メッセージのIDを取得する
            String requestMessageId = requestMessage.getJMSMessageID();

            // 要求元（返送先）のキューを取得する
            Queue replyQueue = (Queue)requestMessage.getJMSReplyTo();

            // 要求メッセージの内容を表示する
            System.out.println("===== RequestMessage =====");
            System.out.println(" RequestMessage ---> " + text);
            System.out.println(" JMSMessageID ---> " + requestMessageId);
            System.out.println(" JMSReplyTo ---> " + replyQueue.getQueueName());

            // 取得したキューからプロデューサを生成する
            MessageProducer producer = session.createProducer(replyQueue);

            // 応答メッセージを生成する
            TextMessage replyMessage = session.createTextMessage();
            replyMessage.setText(text + text);
            replyMessage.setJMSCorrelationID(requestMessageId);

            // 応答メッセージを返送する
            producer.send(replyMessage);

            // 応答メッセージの内容を表示する
            System.out.println("===== ReplyMessage =====");
            System.out.println(" ReplyMessage ---> " + replyMessage.getText());
            System.out.println(" JMSMessageID ---> " + replyMessage.getJMSMessageID());
            System.out.println(" JMSCorrelationID ---> " + replyMessage.getJMSCorrelationID());
        }
    }
}