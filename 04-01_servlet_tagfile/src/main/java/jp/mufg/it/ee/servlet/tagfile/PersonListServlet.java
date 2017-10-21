package jp.mufg.it.ee.servlet.tagfile;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PersonListServlet")
public class PersonListServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PersonServiceBean personService = new PersonServiceBean();
        List<Person> personList = personService.getPersonList();

        request.setAttribute("personList", personList);

        ServletContext context = getServletConfig().getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/PersonListPage.jsp");
        rd.forward(request, response);
    }
}