<%@ tag%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach var="departmentName" items="${departmentBean.departmentNameList}">
  <div>${departmentName}</div>
</c:forEach>
