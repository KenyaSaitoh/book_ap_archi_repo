package jp.mufg.it.ee.servlet.el;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ELServlet")
public class ELServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // リクエストの文字コードを設定する
        request.setCharacterEncoding("UTF-8");

        // セッションスコープに保存するBeanオブジェクトを用意する
        EmployeeBean employee1 = new EmployeeBean();
        employee1.setEmployeeName("<Foo>");
        EmployeeBean employee2 = new EmployeeBean();
        employee2.setEmployeeName("Bar&\"");
        DepartmentBean department = new DepartmentBean();
        department.setDepartmentName("System Department");
        department.getEmployees().add(employee1);
        department.getEmployees().add(employee2);

        // 用意したBeanオブジェクトをセッションスコープに保存する
        HttpSession session = request.getSession();
        session.setAttribute("department", department);

        // 別サーブレットにリクエストをフォワードする
        RequestDispatcher rd = request.getRequestDispatcher("/ELPage2.jsp");
        rd.forward(request, response);
    }
}
