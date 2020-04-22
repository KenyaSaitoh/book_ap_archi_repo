package jp.mufg.it.ee.servlet.dispatch;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/IncludeServlet")
public class IncludeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // レスポンスのコンテントタイプを設定する
        response.setContentType("text/html; charset=UTF-8");

        // HTMLコードを出力する
        PrintWriter out = response.getWriter();
        out.println("<h2>IncludeServlet</h2>");
        out.println("DispatchMainServletでリクエストスコープにセットされたデータ ---> " +
                request.getAttribute("userName") + "<br /><br />");
        out.println("HttpServletRequestに格納されているForwardServletのパス関連情報" + "<br />");
        out.println("ForwardServlet RequestURI ---> " +
                request.getRequestURI() + "<br />");
        out.println("ForwardServlet ContextPath ---> " +
                request.getContextPath() + "<br />");
        out.println("ForwardServlet ServletPath ---> " +
                request.getServletPath() + "<br />");
        out.println("ForwardServlet Query String ---> " +
                request.getQueryString() + "<br /><br />");
        out.println("リクエストスコープにセットされたIncludeServletのパス関連情報<br />");
        out.println("IncludeServlet RequestURI ---> " +
                request.getAttribute("javax.servlet.include.request_uri") + "<br />");
        out.println("IncludeServlet ContextPath ---> " +
                request.getAttribute("javax.servlet.include.context_path") + "<br />");
        out.println("IncludeServlet ServletPath ---> " +
                request.getAttribute("javax.servlet.include.servlet_path") + "<br />");
        out.println("IncludeServlet Query String ---> " +
                request.getAttribute("javax.servlet.include.query_string") + "<br />");
        out.println("<hr />");
    }
}