<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
  <c:import url="./CoreIncludeImportPage2.jsp">
    <c:param name="age" value="50" />
  </c:import>
  <c:import url="./CoreIncludeImportPage2.jsp">
    <c:param name="age" value="35" />
  </c:import>
</body>