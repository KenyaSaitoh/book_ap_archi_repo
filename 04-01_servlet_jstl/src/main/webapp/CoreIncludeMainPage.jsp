<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>CoreIncludeMainPage</title>
<head>
<body>
  <h2>CoreIncludeMainPage</h2>
  <hr />
  <%-- <c:url>タグで指定したコンテンツをインクルード --%>
  <c:url value="./CoreIncludeImportPage1.jsp" var="importPage" scope="page">
    <c:param name="userName" value="Foo" />
  </c:url>
  <c:import url="${importPage}" />
  <hr />
  <%-- <c:import>タグで指定したコンテンツをいったん変数に格納し、その後出力 --%>
  <c:import url="./CoreIncludeImportPage2.jsp" var="importString" scope="page">
    <c:param name="age" value="35" />
  </c:import>
  <c:out value="${importString}" />
</body>