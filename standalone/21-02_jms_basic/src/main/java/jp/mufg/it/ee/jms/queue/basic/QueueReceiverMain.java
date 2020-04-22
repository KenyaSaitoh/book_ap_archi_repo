package jp.mufg.it.ee.jms.queue.basic;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class QueueReceiverMain {

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

        // コンシューマを生成する
        QueueReceiver receiver = session.createReceiver(queue);

        // メッセージリスナを生成し、登録する
        receiver.setMessageListener(new QueueListener());

        // 受信を開始する
        conn.start();
    }
}

/* ============================== */
class QueueListener implements MessageListener {

    // JMSプロバイダからメッセージを受信する
    @Override
    public void onMessage(Message message) {
        System.out.println("[ QueueListener#onMessage ] Start");

        try {
            TextMessage requestMessage = (TextMessage)message;

            // メッセージを表示する
            String text = requestMessage.getText();
            System.out.println("===== Message =====");
            System.out.println(text);

            // プロパティを表示する
            System.out.println("===== Property =====");
            String property = requestMessage.getStringProperty("propertyName");
            System.out.println(property);

            // ヘッダを表示する
            System.out.println("===== Header =====");
            System.out.println(" JMSDestination : " +
                    ((Queue)requestMessage.getJMSDestination()).getQueueName());
            System.out.println(" JMSDeliveryMode : " + requestMessage.getJMSDeliveryMode());
            System.out.println(" JMSRedelivered : " + requestMessage.getJMSRedelivered());
            System.out.println(" JMSMessageID : " + requestMessage.getJMSMessageID());
            System.out.println(" JMSTimestamp : " + requestMessage.getJMSTimestamp());
            System.out.println(" JMSExpiration : " + requestMessage.getJMSExpiration());
            System.out.println(" JMSPriority : " + requestMessage.getJMSPriority());
        } catch (JMSException jmse) {
            throw new RuntimeException(jmse);
        }

        System.out.println("[ QueueListener#onMessage ] End");
    }
}