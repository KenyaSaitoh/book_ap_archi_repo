<%@ tag pageEncoding="UTF-8" %>
<%@ attribute name="border" required="true"%>
<%@ attribute name="style"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table border="${border}" style="${style}">
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