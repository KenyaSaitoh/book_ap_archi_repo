package jp.mufg.it.ee.jms.topic.basic;

import java.util.Properties;

import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;

public class TopicPublisherMain {

    public static void main(String[] args) throws Exception {
        // JMS管理オブジェクトのイニシャルコンテキストを生成する
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.put(Context.PROVIDER_URL, "tcp://localhost:61616");
        Context context = new InitialContext(props);

        // JMSコネクションファクトリをJNDIルックアップにより取得する
        TopicConnectionFactory factory = (TopicConnectionFactory)context
                .lookup("ConnectionFactory");

        // トピックをJNDIルックアップにより取得する
        Topic topic = (Topic)context.lookup("dynamicTopics/MyTopic");

        // JMSコネクションをJMSコネクションファクトリから取得する
        TopicConnection conn = factory.createTopicConnection();

        // JMSセッションを生成する
        TopicSession session = conn.createTopicSession(false,
                Session.AUTO_ACKNOWLEDGE);

        // メッセージプロデューサを生成する
        TopicPublisher publisher = session.createPublisher(topic);

        // メッセージを生成する
        TextMessage textMessage = session.createTextMessage();
        textMessage.setText("Foo");

        // メッセージを送信する
        publisher.send(textMessage);

        conn.close();
    }
}