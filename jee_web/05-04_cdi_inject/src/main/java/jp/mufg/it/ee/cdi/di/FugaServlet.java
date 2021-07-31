package jp.mufg.it.ee.cdi.di;

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
    private Foo foo;

    // doPostメソッド
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // ビジネスメソッドを呼び出す
        int answer = foo.doBusiness(3);

        // 結果を画面に出力する
        PrintWriter out = response.getWriter();
        out.print("NORMAL END ( Answer => " + answer + " )");
        out.close();
    }
}