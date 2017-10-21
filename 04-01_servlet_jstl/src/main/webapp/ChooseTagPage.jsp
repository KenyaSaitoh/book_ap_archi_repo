<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>ChooseTagPage</title>
</head>
<body>
  <h2>ChooseTagPage</h2>
  <hr />
  <c:choose>
    <c:when test="${param.status == '1'}">
      <div>正常終了：ステータスは1でした</div>
    </c:when>
    <c:when test="${param.status == '2'}">
      <div>正常終了：ステータスは2でした</div>
    </c:when>
    <c:otherwise>
      <div>
        <span>異常終了：ステータスは</span>
        <c:out value="${param.status}" />
        <span>でした</span>
      </div>
    </c:otherwise>
  </c:choose>
</body>
</html>