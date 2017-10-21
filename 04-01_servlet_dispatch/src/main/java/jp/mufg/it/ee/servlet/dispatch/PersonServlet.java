package jp.mufg.it.ee.servlet.dispatch;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Person")
public class PersonServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // リクエストの文字コードを設定する
        request.setCharacterEncoding("UTF-8");

        // 入力値を取得する
        String personName = request.getParameter("personName");
        Integer age = Integer.parseInt(request.getParameter("age"));

        // リクエストスコープにモデルを格納する
        request.setAttribute("personName", personName);
        request.setAttribute("age", age);

        // リクエストをJSPページにフォワードする
        RequestDispatcher rd = request.getRequestDispatcher(
                "./ParamSubmitPage.jsp");
        rd.forward(request, response);
    }
}