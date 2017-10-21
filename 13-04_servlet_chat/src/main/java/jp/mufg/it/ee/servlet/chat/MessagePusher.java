package jp.mufg.it.ee.servlet.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.AsyncContext;
import javax.servlet.ServletResponse;

public class MessagePusher {
    private static MessagePusher instance = new MessagePusher();

    // 同じAsyncContextオブジェクトが登録されても上書きされるように、Setを使う
    private Set<AsyncContext> contextSet = Collections.synchronizedSet(
            new HashSet<AsyncContext>());

    private MessagePusher() {
    }

    // インスタンスを返す（シングルトンパターン）
    public static MessagePusher getInstance() {
        return instance;
    }

    // リスナーを登録する
    public void addContext(AsyncContext aContext) {
        contextSet.add(aContext);
    }

    // メッセージを配信する
    public void pushMessage(String message) {
        synchronized(contextSet) {
            Iterator<AsyncContext> i = contextSet.iterator();
            while (i.hasNext()) {
                AsyncContext aContext = i.next();
                ServletResponse response = aContext.getResponse();
                response.setContentType("text/plain; charset=UTF-8");
                try {
                    PrintWriter out = response.getWriter();
                    out.println(message);
                    out.flush();
                    // コンテキストをいったん終了しないと、クライアントにレスポンスは返らない
                    aContext.complete();
                } catch (IOException ioe) {
                    aContext.complete();
                    i.remove();
                }
            }
        }
        // 再接続に備えてクリアする
        contextSet.clear();
    }
}