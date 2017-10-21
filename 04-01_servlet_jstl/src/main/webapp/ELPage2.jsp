<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<title>ELPage2</title>
</head>
<body>
  <h2>ELPage2</h2>
  <hr />
  <div>入力パラメータcolorsを出力</div>
  <div>param.colors ---> ${param.colors}</div>
  <div>paramValues.colors[0] ---> ${paramValues.colors[0]}</div>
  <div>paramValues.colors[1] ---> ${paramValues.colors[1]}</div>
  <div>入力パラメータの値の連結</div>
  <div>param.value1 param.value2 ---> ${param.value1} ${param.value2}</div>
  <div>入力パラメータの値の演算</div>
  <div>param.value1 + param.value2 ---> ${param.value1 + param.value2}</div>
  <hr />
  <div>入力パラメータcolorsを取り出し、リクエストスコープにmyColorとして保存</div>
  <c:set var="myColor" scope="request" value="${param.colors}" />
  <div>リクエストスコープ内のmyColorを出力</div>
  <div>${requestScope.myColor}</div>
  <hr />
  <div>HTTPヘッダを出力</div>
  <div>header['Accept-Language'] ---> ${header['Accept-Language']}</div>
  <div>headerValues['User-Agent'][0] ---> ${headerValues['User-Agent'][0]}</div>
  <hr />
  <div>セッションスコープに保存されたDepartmentBeanのdepartmentNameを出力</div>
  <div>department.departmentName ---> ${department.departmentName}</div>
  <div>セッションスコープに保存されたDepartmentBeanのemployees（リスト）の各employeeNameを出力</div>
  <div>department.employees[0].employeeName ---> ${fn:escapeXml(department.employees[0].employeeName)}</div>
  <div>department.employees[1].employeeName ---> ${fn:escapeXml(department.employees[1].employeeName)}</div>
  <hr />
  <div>コンテキスト初期化パラメータuserNameを出力</div>
  <div>initParam.userName ---> ${initParam.userName}</div>
</body>
</html>