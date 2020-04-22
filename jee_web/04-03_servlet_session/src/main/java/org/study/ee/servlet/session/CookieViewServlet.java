package org.study.ee.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieViewServlet")
public class CookieViewServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // リクエストの文字コードを設定する
        request.setCharacterEncoding("UTF-8");

        // レスポンスのコンテントタイプを設定する
        response.setContentType("text/html; charset=UTF-8");

        // HTMLコードを出力する
        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();
        out.println("<html>");
        out.println("<head><title>CookieViewerServle</title></head>");
        out.println("<body>");
        out.println("<h2>CookieViewerServle</h2><hr />");
        out.println("WebブラウザからのHTTPリクエスト内にセットされているクッキー一覧<br /><br />");
        for (int i = 0; i < cookies.length; i++) {
            out.println("Cookie[" + i + "] Name ---> " + cookies[i].getName() + "<br />");
            out.println("Cookie[" + i + "] Value ---> " + cookies[i].getValue() + "<br />");
            out.println("Cookie[" + i + "] Comment ---> " + cookies[i].getComment()
                    + "<br />");
            out.println("Cookie[" + i + "] Max Age ---> " + cookies[i].getMaxAge()
                    + "<br />");
            out.println("Cookie[" + i + "] Domain ---> " + cookies[i].getDomain()
                    + "<br />");
            out.println("Cookie[" + i + "] Path ---> " + cookies[i].getPath() + "<br />");
            out.println("Cookie[" + i + "] Version ---> " + cookies[i].getVersion()
                    + "<br />");
            out.println("<br />");
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}