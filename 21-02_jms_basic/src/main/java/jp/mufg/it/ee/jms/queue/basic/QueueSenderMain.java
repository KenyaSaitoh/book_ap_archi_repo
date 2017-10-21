package jp.mufg.it.ee.jms.queue.basic;

import java.util.Properties;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class QueueSenderMain {

    public static void main(String[] args) throws Exception {
        // JMS管理オブジェクトのイニシャルコンテキストを生成する
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.put(Context.PROVIDER_URL, "tcp://localhost:61616");
        Context context = new InitialContext(props);

        // JMSコネクションファクトリをJNDIルックアップにより取得する
        QueueConnectionFactory factory = (QueueConnectionFactory)context
                .lookup("ConnectionFactory");

        // キューをJNDIルックアップにより取得する
        Queue queue = (Queue)context.lookup("dynamicQueues/MyQueue");

        // JMSコネクションをJMSコネクションファクトリから取得する
        QueueConnection conn = factory.createQueueConnection();

        // JMSセッションを生成する
        QueueSession session = conn.createQueueSession(false,
                Session.AUTO_ACKNOWLEDGE);

        // プロデューサを生成する
        QueueSender sender = session.createSender(queue);

        // メッセージを生成する
        TextMessage textMessage = session.createTextMessage();
        textMessage.setText("Foo");

        // メッセージを送信する
        sender.send(textMessage);

        // JMSコネクションを閉じる
        conn.close();
    }
}