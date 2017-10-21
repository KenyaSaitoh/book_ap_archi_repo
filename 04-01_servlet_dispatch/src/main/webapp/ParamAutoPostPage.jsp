<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<html>
<head>
<title>ParamAutoPostPage</title>
<script type="text/javascript">
    function autoSubmit() {
        document.forms[0].submit();
    }
</script>
</head>
<body onload="setTimeout('autoSubmit()',5000)">
  <h2>ParamAutoPostPage</h2>
  <hr />
  <div>5秒後に、パラメータがParamViewerServletにPOSTで送信されます</div>
  <form action="/servlet_dispatch/ParamViewServlet" method="POST">
    <%
        Enumeration<String> e = request.getParameterNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = request.getParameter(key);
    %>
    <input type="hidden" name="<%=key%>" value="<%=value%>">
    <%
        }
    %>
  </form>
</body>
</html>