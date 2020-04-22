<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>ForwardPage</title>
<head>
<body>
  <h2>ForwardPage</h2>
  <div>ForwardPageによるPage生成部分</div>
  <div>現在日時を表示するJSPページをインクルードする</div>
  <hr />
  <jsp:include page="/IncludePage.jsp">
    <jsp:param name="userName" value="Foo" />
  </jsp:include>
  <hr />
  <div>再びForwardPageによるPage生成部分</div>
</body>
</html>