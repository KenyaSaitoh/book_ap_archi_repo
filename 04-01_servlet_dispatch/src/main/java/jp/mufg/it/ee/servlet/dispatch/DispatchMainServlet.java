package jp.mufg.it.ee.servlet.dispatch;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/DispatchMainServlet")
public class DispatchMainServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // リクエストの文字コードを設定する
        request.setCharacterEncoding("UTF-8");

        // レスポンスのコンテントタイプを設定する
        response.setContentType("text/html; charset=UTF-8");

        // HTMLコードを出力する
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>DispatchMainServlet</title></head>");
        out.println("<body>");
        out.println("<h2>DispatchMainServlet</h2>");
        out.println("ForwardServletへの転送前<br />");

        // 別サーブレットにリクエストをフォワードする
        request.setAttribute("userName", "Bar");
        RequestDispatcher rd = request.getRequestDispatcher("/ForwardServlet");
        rd.forward(request, response);

        // HTMLコードを再度出力する
        out.println("ForwardServletへの転送後<br />");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}