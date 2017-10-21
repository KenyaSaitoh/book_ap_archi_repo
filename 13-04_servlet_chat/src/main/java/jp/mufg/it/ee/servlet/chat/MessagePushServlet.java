package jp.mufg.it.ee.servlet.chat;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MessagePushServlet")
public class MessagePushServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MessagePusher pusher = MessagePusher.getInstance();
        String message = request.getParameter("message");
        if (message != null) {
            pusher.pushMessage(message);
        }
    }
}
