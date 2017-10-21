package jp.mufg.it.ee.websocket.chat;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class ChatServerEndpoint {

    private static Set<Session> sessionSet = Collections.synchronizedSet(
            new HashSet<Session>());

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("[ ChatServerEndpoint#onOpen ]");
        sessionSet.add(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("[ ChatServerEndpoint#onMessage ]");
        System.out.println("message ---> " + message);
        for (Session eachSession : sessionSet) {
            eachSession.getBasicRemote().sendText(message);
        }
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("[ ChatServerEndpoint#onClose ]");
        sessionSet.remove(session);
    }
}
