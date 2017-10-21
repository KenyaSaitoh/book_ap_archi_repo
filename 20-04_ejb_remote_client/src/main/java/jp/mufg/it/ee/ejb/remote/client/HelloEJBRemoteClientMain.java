package jp.mufg.it.ee.ejb.remote.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class HelloEJBRemoteClientMain {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("java.naming.factory.initial",
                "com.sun.enterprise.naming.SerialInitContextFactory");
        props.put("org.omg.CORBA.ORBInitialHost", "localhost");
        props.put("org.omg.CORBA.ORBInitialPort", "3700");
        Hello hello = null;
        try {
            // イニシャルコンテキストを取得する
            Context context = new InitialContext(props);
            // セッションBeanオブジェクトをJNDIルックアップにより取得する
            hello = (Hello)context.lookup(
                    "java:global/ejb_remote_ejbjar/HelloBean");
        } catch (NamingException ne) {
            throw new RuntimeException(ne);
        }

        // ビジネスメソッドを呼び出す
        String result = hello.sayHello("Stateless Remote SessionBean");

        System.out.println(result);
    }
}
