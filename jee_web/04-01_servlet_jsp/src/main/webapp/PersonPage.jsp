<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%
    String personName = request.getParameter("personName");
    String country = request.getParameter("country");
%>
<html>
<body>
<div><%= personName %>さんのメッセージ</div>
<% if (country != null && country.equals("japan")) { %>
  <div>こんにちは！私は<%= personName %>です</div>
<% } else { %>
  <div>Hello! I'm <%= personName %>.</div>
<% } %>
</body>
</html>