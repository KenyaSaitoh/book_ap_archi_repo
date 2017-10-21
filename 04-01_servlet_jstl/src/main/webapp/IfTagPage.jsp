<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>IfTagPage</title>
</head>
<body>
  <h2>IfTagPage</h2>
  <hr />
  <%
      boolean flag = true;
      pageContext.setAttribute("flag", new Boolean(flag));
  %>
  <c:if test="${flag}">
    <div>flagはtrueでした</div>
  </c:if>
</body>
</html>