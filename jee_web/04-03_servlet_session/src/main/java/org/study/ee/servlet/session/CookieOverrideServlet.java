package org.study.ee.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieOverrideServlet")
public class CookieOverrideServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // リクエストの文字コードを設定する
        request.setCharacterEncoding("UTF-8");

        // クッキー1を設定する
        Cookie cookie1 = new Cookie("userName", "Bar");
        response.addCookie(cookie1);

        // クッキー2を設定する
        Cookie cookie2 = new Cookie("age", "30");
        cookie2.setDomain(".hoge.localdomain");
        response.addCookie(cookie2);

        // レスポンスのコンテントタイプを設定する
        response.setContentType("text/html; charset=UTF-8");

        // HTMLコードを出力する
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>CookieOverrideServlet</title></head>");
        out.println("<body>");
        out.println("<h2>CookieOverrideServlet</h2><hr />");
        out.println("HTTPレスポンスにクッキーをセットしました<br /><br />");
        out.println("<a href='/web_session/CookieViewServlet'>このリンクをクリックすると、CookieViewServletが呼び出されます<a>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}