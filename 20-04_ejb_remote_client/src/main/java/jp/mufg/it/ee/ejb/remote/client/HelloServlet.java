package jp.mufg.it.ee.ejb.remote.client;

import java.io.IOException;
import java.io.PrintWriter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Hello hello = null;
        try {
            // イニシャルコンテキストを取得する
            Context context = new InitialContext();
            // セッションBeanオブジェクトをJNDIルックアップにより取得する
            hello = (Hello)context.lookup(
                    "java:global/ejb_remote_ejbjar/HelloBean");
        } catch (NamingException ne) {
            throw new RuntimeException(ne);
        }

        // ビジネスメソッドを呼び出す
        String result = hello.sayHello("Stateless Remote SessionBean");

        // HTMLコードを出力する
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>HelloServlet</title></head>");
        out.println("<body>");
        out.println("<h2>HelloServlet</h2><hr />");
        out.println(result + "<br />");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}