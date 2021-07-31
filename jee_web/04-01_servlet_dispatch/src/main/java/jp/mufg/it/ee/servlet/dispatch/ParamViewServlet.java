package jp.mufg.it.ee.servlet.dispatch;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ParamViewServlet")
public class ParamViewServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // リクエストの文字コードを設定する
        request.setCharacterEncoding("UTF-8");

        // レスポンスのコンテントタイプを設定する
        response.setContentType("text/html; charset=UTF-8");

        // HTMLコードを出力する
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>ParamViewServlet</title></head>");
        out.println("<body>");
        out.println("<h2>ParamViewServlet</h2><hr />");
        out.println("Query String => " + request.getQueryString() + "<hr />");
        String paramName, paramValue;
        Enumeration<String> e = request.getParameterNames();
        while (e.hasMoreElements()) {
            paramName = e.nextElement();
            paramValue = request.getParameter(paramName);
            out.println(paramName + " => " + paramValue + "<br />");
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
