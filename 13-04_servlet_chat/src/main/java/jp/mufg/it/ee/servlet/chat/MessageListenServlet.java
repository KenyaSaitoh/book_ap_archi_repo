package jp.mufg.it.ee.servlet.chat;

import java.io.IOException;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/MessageListenServlet", asyncSupported = true)
public class MessageListenServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // AsyncContextを取得する（リクエスト・レスポンスがリスンスレッドから切り離される）
        AsyncContext aContext = request.startAsync();

        // AsyncContextをセットアップする
        aContext.addListener(new AsyncListenerImpl());
        aContext.setTimeout(100000);

        // MessagePusherオブジェクトにAsyncContextオブジェクトを登録する
        MessagePusher pusher = MessagePusher.getInstance();
        pusher.addContext(aContext);
    }

    class AsyncListenerImpl implements AsyncListener {

        @Override
        public void onComplete(AsyncEvent event) throws IOException {
            System.out.println("[ AsyncListenerImpl ] complete");
        }

        @Override
        public void onError(AsyncEvent event) throws IOException {
            System.out.println("[ AsyncListenerImpl ] error");
        }

        @Override
        public void onStartAsync(AsyncEvent event) throws IOException {
            System.out.println("[ AsyncListenerImpl ] start");
        }

        @Override
        public void onTimeout(AsyncEvent event) throws IOException {
            System.out.println("[ AsyncListenerImpl ] timeout");
            // 元のサーブレットに処理をディスパッチする
            AsyncContext aContext = event.getAsyncContext();
            aContext.dispatch(getServletContext(), "/MessageListenServlet");
        }
    }
}