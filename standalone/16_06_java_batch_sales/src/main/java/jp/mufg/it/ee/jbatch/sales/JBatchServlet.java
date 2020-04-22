package jp.mufg.it.ee.jbatch.sales;

import java.io.IOException;
import java.io.PrintWriter;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JBatchServlet")
public class JBatchServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        // ジョブの起動
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        long executionId = jobOperator.start("sales-batch-job", null);

        // 結果を画面に出力する。
        PrintWriter out = response.getWriter();
        out.println("NORMAL END");
        out.println("executionId ---> " + executionId);
        out.close();
    }
}