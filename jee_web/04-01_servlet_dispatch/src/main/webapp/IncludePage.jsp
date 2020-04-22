<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.DateFormat"%>
<h2>IncludePage</h2>
<%=DateFormat.getDateTimeInstance().format(new Date())%><br />
<span>引き渡されたパラメータ ---> </span>
<%
    out.println(request.getParameter("userName"));
%>