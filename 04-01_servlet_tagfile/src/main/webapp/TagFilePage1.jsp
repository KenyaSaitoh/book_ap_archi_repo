<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags/hoge" prefix="foo"%>
<%-- タグファイルの際は、taglibディレクティブのtagdir属性は、
     必ず"/WEB-INF/tags"で始まる必要がある模様--%>
<html>
<head>
<title>TagFilePage1</title>
</head>
<body>
  <h2>TagFilePage1</h2>
  <hr />
  <hoge:hoge value="Tagfile" />
</body>
</html>