package org.study.ee.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ColorSessionServlet")
public class ColorSessionServlet extends HttpServlet {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // リクエストの文字コードを設定する
        request.setCharacterEncoding("UTF-8");

        // 入力値を取得する
        String selectedcolor = request.getParameter("selectedColor");

        // セッションを生成・復元する
        HttpSession session = request.getSession();

        System.out.println("jsessionId ---> " + session.getId());

        ArrayList<String> colorList = null;
        // セッションが新規、またはセッションは新規ではないが
        // カラーリストがない格納されていない場合、新規でカラーリストを生成する
        if (session.isNew() || session.getAttribute("selectedColorList") == null) {
            colorList = new ArrayList<String>();
        } else {
            // すでにカラーリストがセッションにある場合、セッションから取り出す
            colorList = (ArrayList<String>)session.getAttribute("selectedColorList");
        }

        // 選択された色をカラーリストに追加し、セッションスコープに格納する
        colorList.add(selectedcolor);
        session.setAttribute("selectedColorList", colorList);

        // レスポンスのコンテントタイプを設定する
        response.setContentType("text/html; charset=UTF-8");

        // HTMLコードを出力する
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>ColorSessionServlet</title></head>");
        out.println("<body>");
        out.println("<h2>ColorSessionServlet</h2><hr />");
        out.println("今までに選択された色<br />");
        Iterator i = colorList.iterator();
        while (i.hasNext()) {
            String color = (String)i.next();
            out.println(color + "<br />");
        }
        out.println("</body></html>");
        out.close();
    }
}