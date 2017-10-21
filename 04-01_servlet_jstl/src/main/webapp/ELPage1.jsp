﻿<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>ELPage1</title>
</head>
<body>
  <h2>ELPage1</h2>
  <hr />
  <div>c:setタグで変数を設定（x=10、y=20）</div>
  <c:set var="x" value="10" />
  <c:set var="y" scope="request" value="20" />
  <div>スクリプトレットでセッションスコープに変数を保存（z=30）</div>
  <%
      session.setAttribute("z", new Integer(30));
  %>
  <div>ELで出力</div>
  <div>x + y + z ---> ${x + y + z}</div>
  <div>c:removeタグで変数（y）を削除</div>
  <c:remove var="y" scope="request" />
  <div>ELで再度出力</div>
  <div>x + y + z ---> ${x + y + z}</div>
</body>
</html>