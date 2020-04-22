<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>CoreIncludeImportPage1</h2>
<hr />
<div>
  userName ---> <c:out value="${param.userName}" />
</div>