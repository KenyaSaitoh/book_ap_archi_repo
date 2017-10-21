<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>ParamSubmitPage</title>
<script type="text/javascript">
window.onload = function() {
  document.forms[0].submit();
}
</script>
</head>
<body>
  <h2>ParamSubmitPage</h2>
  <hr />
  <form action="/servlet_dispatch/ParamViewServlet" method="POST">
    <input type="hidden" name="personName" value="${personName}" />
    <input type="hidden" name="age" value="${age}" />
  </form>
</body>
</html>