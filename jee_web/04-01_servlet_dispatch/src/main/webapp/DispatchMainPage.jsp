<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>DispatchMainPage</title>
<head>
<body>
  <h2>DispatchMainPage</h2>
  <hr />
  <div>フォワードによってこの文字列はクリアされる</div>
  <jsp:forward page="/ForwardPage.jsp" />
  <div>フォワード後のこの文字列も処理されない</div>
</body>