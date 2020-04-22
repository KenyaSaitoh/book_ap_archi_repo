<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>CoreTagPage4</title>
</head>
<body>
  <h2>CoreTagPage4</h2>
  <hr />
  <%@ page import="java.util.*"%>
  <%-- 配列を生成し、リクエストスコープに保存 --%>
  <%
      String[] array = { "Foo", "FooFoo", "FooFooFoo" };
      request.setAttribute("fooArray", array);
  %>
  <%-- リストを生成し、リクエストスコープに保存 --%>
  <%
      List list = new ArrayList();
      list.add("Bar");
      list.add("BarBar");
      list.add("BarBarBar");
      request.setAttribute("barList", list);
  %>
  <%-- マップを生成し、リクエストスコープに保存 --%>
  <%
      Map map = new HashMap();
      map.put("X", "Baz");
      map.put("Y", "BazBaz");
      map.put("Z", "BazBazBaz");
      request.setAttribute("bazMap", map);
  %>
  <div>リクエストスコープから取り出して、個別に出力</div>
  <div>
    <span>foo[0] ---> </span>
    <c:out value="${fooArray[0]}" />
  </div>
  <div>
    <span>bar[1] ---> </span>
    <c:out value="${barList[1]}" />
  </div>
  <div>
    <span>baz['Z'] ---> </span>
    <c:out value="${bazMap['Z']}" />
  </div>
  <div>barListの内容をすべて出力</div>
  <div>
    <c:forEach var="item" items="${barList}" varStatus="status">
      <div>
        <c:out value="${status.index}" />
        <span>:</span>
        <c:out value="${item}" />
      </div>
    </c:forEach>
  </div>
  <div>bazMapの内容をすべて出力</div>
  <div>
    <c:forEach var="item" items="${bazMap}" varStatus="status">
      <c:out value="${status.index}" />
      <span>:</span>
      <c:out value="${item.key}" /> ---> <c:out value="${item.value}" />
    </c:forEach>
  </div>
</body>
</html>