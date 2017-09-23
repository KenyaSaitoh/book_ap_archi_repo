package jp.mufg.it.ee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/PersonServlet")
public class PersonServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // リクエストの文字コードを設定する
        request.setCharacterEncoding("UTF-8");

        // 入力値を取得する
        String personName = request.getParameter("personName");
        String country = request.getParameter("country");

        // ビジネスロジックを実行する
        String message = null;
        if (country != null && country.equals("japan")) {
            message = "こんにちは！私は" + personName + "です。";
        } else {
            message = "Hello! I'm " + personName + ".";
        }

        // ビジネスロジックの結果を含むHTMLコードを出力する
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<div>" + personName + "さんのメッセージ</div>");
        out.println("<div>" + message + "</div>");
        out.println("</body>");
        out.println("</html>");
    }
}