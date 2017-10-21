<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>CoreTagPage3</title>
</head>
<body>
  <h2>CoreTagPage3</h2>
  <hr />
  <table border=1">
    <c:forEach begin="1" end="9" var="i">
      <tr>
        <c:forEach begin="1" end="9" var="j">
          <td><c:out value="${i * j}" /></td>
        </c:forEach>
      </tr>
    </c:forEach>
  </table>
</body>
</html>
