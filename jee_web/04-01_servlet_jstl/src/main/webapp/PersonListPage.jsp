<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>PersonListPage</title>
</head>
<body>
  <h2>PersonListPage</h2>
  <hr />
  <table border="1">
    <tr>
      <th>ID</th>
      <th>名前</th>
      <th>年齢</th>
    </tr>
    <c:forEach items="${personList}" var="person">
      <tr>
        <td>${person.personId}</td>
        <td>${person.personName}</td>
        <td>${person.age}</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>