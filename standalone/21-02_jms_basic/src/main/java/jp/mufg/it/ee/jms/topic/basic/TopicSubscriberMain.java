package jp.mufg.it.ee.jms.topic.basic;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;

public class TopicSubscriberMain {

    public static void main(String[] args) throws Exception {
        // JMS管理オブジェクトのイニシャルコンテキストを生成する
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.put(Context.PROVIDER_URL, "tcp://localhost:61616");
        Context context = new InitialContext(props);

        // JMSコネクションファクトリをJNDIルックアップにより取得する
        TopicConnectionFactory connectionFactory =
                (TopicConnectionFactory)context.lookup("ConnectionFactory");

        // トピックをJNDIルックアップにより取得する
        Topic topic = (Topic)context.lookup("dynamicTopics/MyTopic");

        // JMSコネクションをJMSコネクションファクトリから取得する
        TopicConnection conn = connectionFactory.createTopicConnection();

        // JMSセッションを生成する
        TopicSession session =
                conn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

        // コンシューマを生成する
        TopicSubscriber subscriber = session.createSubscriber(topic);

        // メッセージリスナを生成し、登録する
        subscriber.setMessageListener(new TopicListener());

        // 配信の要求を開始する
        conn.start();
    }
}

/* ============================== */
class TopicListener implements MessageListener {

    // JMSプロバイダからメッセージを受信する
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
                    ((Topic)requestMessage.getJMSDestination()).getTopicName());
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