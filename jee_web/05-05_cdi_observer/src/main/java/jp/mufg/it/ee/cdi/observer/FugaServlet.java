package jp.mufg.it.ee.cdi.observer;

import java.io.IOException;
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

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // ビジネスメソッドを呼び出す
        fooBean.doBusiness();
    }
}