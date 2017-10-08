package jp.mufg.it.ee.cdi.producer3;

import java.io.IOException;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/FugaServlet3")
public class FugaServlet extends HttpServlet {
    // インジェクションポイント
    @Inject
    private DataSource ds;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            int il = ds.getConnection().getTransactionIsolation();
            System.out.println(il);
        } catch(SQLException sqle) {
        }
    }
}