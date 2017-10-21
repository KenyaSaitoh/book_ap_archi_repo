package jp.mufg.it.ee.ejb.async;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FugaServlet")
public class FugaServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        AsyncBean asyncBean = null;
        try {
            // イニシャルコンテキストを取得する
            Context context = new InitialContext();
            // セッションBeanオブジェクトをJNDIルックアップにより取得する
            asyncBean = (AsyncBean)context.lookup("java:module/AsyncBean");
        } catch (NamingException ne) {
            throw new RuntimeException(ne);
        }

        // ビジネスメソッドを呼び出す
        Future<Integer> future = asyncBean.execute("Foo");

        // 結果を受け取る
        int answer;
        try {
            answer = future.get();
        } catch(InterruptedException ie) {
            throw new RuntimeException(ie);
        } catch(ExecutionException ee) {
            throw new RuntimeException(ee);
        }

        // 結果を画面に出力する
        PrintWriter out = response.getWriter();
        out.print("NORMAL END ( Answer ---> " + answer + " )");
        out.close();
    }
}