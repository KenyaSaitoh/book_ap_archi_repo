package org.study.ee.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieSetServlet")
public class CookieSetServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // リクエストの文字コードを設定する
        request.setCharacterEncoding("UTF-8");

        // クッキー1を設定する
        Cookie cookie1 = new Cookie("userName", "Foo");
        response.addCookie(cookie1);

        // クッキー2を設定する
        Cookie cookie2 = new Cookie("age", "35");
        cookie2.setMaxAge(3600);
        response.addCookie(cookie2);

        // クッキー3（セキュアクッキー）を設定する
        Cookie cookie3 = new Cookie("gender", "male");
        cookie3.setSecure(true);
        response.addCookie(cookie3);

        // クッキー4（セキュアクッキー）を設定する
        Cookie cookie4 = new Cookie("job", "Manager");
        cookie2.setDomain("www.mufg.jp");
        response.addCookie(cookie4);

        // レスポンスのコンテントタイプを設定する
        response.setContentType("text/html; charset=UTF-8");

        // HTMLコードを出力する
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>CookieSetServlet</title></head>");
        out.println("<body>");
        out.println("<h2>CookieSetServlet</h2><hr />");
        out.println("HTTPレスポンスにクッキーをセットしました<br /><br />");
        out.println("<a href='/web_session/CookieViewServlet'>このリンクをクリックすると、CookieViewServletが呼び出されます<a>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}