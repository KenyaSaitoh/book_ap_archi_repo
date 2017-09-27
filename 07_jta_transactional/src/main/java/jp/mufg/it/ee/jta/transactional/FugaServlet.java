package jp.mufg.it.ee.jta.transactional;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FugaServlet")
public class FugaServlet extends HttpServlet {
    // インジェクションポイント
    @Inject
    private FooBean fooBean;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // 入力値を取得する
        Integer param = Integer.parseInt(request.getParameter("param"));

        // ビジネスメソッドを呼び出す
        fooBean.doBusiness(param);

        // 画面に出力して終了する
        PrintWriter out = response.getWriter();
        out.print("NORMAL END");
        out.close();
    }
}