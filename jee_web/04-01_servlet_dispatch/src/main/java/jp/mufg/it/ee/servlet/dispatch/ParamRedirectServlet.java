package jp.mufg.it.ee.servlet.dispatch;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ParamRedirectServlet")
public class ParamRedirectServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // リクエストの文字コードを設定する
        request.setCharacterEncoding("UTF-8");

        // リダイレクトする
        String queryString = request.getQueryString();
        String contextPath = request.getServletContext().getContextPath();
        String redirectUri = contextPath + "/ParamViewServlet?"
                + queryString;
        response.sendRedirect(redirectUri);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 別JSPページにリクエストをフォワードする
        RequestDispatcher rd = request.getRequestDispatcher("/ParamAutoPostPage.jsp");
        rd.forward(request, response);
    }
}