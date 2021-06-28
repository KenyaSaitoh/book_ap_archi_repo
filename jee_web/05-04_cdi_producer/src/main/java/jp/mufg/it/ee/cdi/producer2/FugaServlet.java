package jp.mufg.it.ee.cdi.producer2;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/FugaServlet2")
public class FugaServlet extends HttpServlet {
    // インジェクションポイント
    @Inject
    private Logger logger;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        logger.info("[ FugaServlet#doGet ]");
    }
}