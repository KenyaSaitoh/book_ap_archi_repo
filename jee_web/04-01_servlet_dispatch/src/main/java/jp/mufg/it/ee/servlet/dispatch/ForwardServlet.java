package jp.mufg.it.ee.servlet.dispatch;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ForwardServlet")
public class ForwardServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // リクエストの文字コードを設定する
        request.setCharacterEncoding("UTF-8");

        // レスポンスのコンテントタイプを設定する
        response.setContentType("text/html; charset=UTF-8");

        // HTMLコードを出力する
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>ForwardServlet</title></head>");
        out.println("<body>");
        out.println("<h2>ForwardServlet</h2>");
        out.println("DispatchMainServletでリクエストスコープにセットされたデータ ---> "
                + request.getAttribute("userName") + "<br /><br />");
        out.println("HttpServletRequestに格納されているパス関連情報" + "<br />");
        out.println("RequestURL ---> " + request.getRequestURL() + "<br />");
        out.println("RequestURI ---> " + request.getRequestURI() + "<br />");
        out.println("ContextPath ---> " + request.getContextPath() + "<br />");
        out.println("ServletPath ---> " + request.getServletPath() + "<br />");
        out.println("Query String ---> " + request.getQueryString() + "<br />");
        out.println("以下はIncludeServletの処理結果をインクルード");
        out.println("<hr />");

        // 別サーブレットにリクエストをインクルードする
        RequestDispatcher rd = request.getRequestDispatcher("/IncludeServlet?age=35");
        rd.include(request, response);

        // HTMLコードを出力する
        out.println("ForwardServlet終了<br />");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}