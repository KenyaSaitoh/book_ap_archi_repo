<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>CoreTagPage2</title>
</head>
<body>
  <h2>CoreTagPage2</h2>
  <hr />
  <div>入力パラメータcolorsを出力</div>
  <div>
    <span>param.colors ---> </span>
    <c:out value="${param.colors}" />
  </div>
  <div>
    <span>paramValues.colors[0] ---> </span>
    <c:out value="${paramValues.colors[0]}" />
  </div>
  <div>
    <span>paramValues.colors[1] ---> </span>
    <c:out value="${paramValues.colors[1]}" />
  </div>
  <div>入力パラメータの値の連結</div>
  <div>
    <span>param.value1 param.value2 ---> </span>
    <c:out value="${param.value1} ${param.value2}" />
  </div>
  <div>入力パラメータの値の演算</div>
  <div>
    <span>param.value1 + param.value2 ---> </span>
    <c:out value="${param.value1 + param.value2}" />
  </div>
  <hr />
  <div>入力パラメータcolorsを取り出し、リクエストスコープにmyColorとして保存</div>
  <div>
    <c:set var="myColor" scope="request" value="${param.colors}" />
    <div>リクエストスコープ内のmyColorを出力</div>
    <div>
      <span>myColor ---> </span>
      <c:out value="${requestScope.myColor}" />
    </div>
    <hr />
    <div>HTTPヘッダを出力</div>
    <div>
      <span>header['Accept-Language'] ---> </span>
      <c:out value="${header['Accept-Language']}" />
    </div>
    <div>
      <span>headerValues['User-Agent'][0] ---> </span>
      <c:out value="${headerValues['User-Agent'][0]}" />
    </div>
    <hr />
    <div>セッションスコープに保存されたDepartmentBeanのdepartmentNameを出力</div>
    <div>
      <span>department.departmentName ---> </span>
      <c:out value="${department.departmentName}" />
    </div>
    <div>セッションスコープに保存されたDepartmentBeanのemployees（リスト）の各employeeNameを出力</div>
    <div>
      <span>department.employees[0].employeeName ---> </span>
      <c:out value="${department.employees[0].employeeName}" />
    </div>
    <div>
      <span>department.employees[1].employeeName ---> </span>
      <c:out value="${department.employees[1].employeeName}" />
    </div>
    <hr />
    <div>コンテキスト初期化パラメータuserNameを出力</div>
    <div>
      <span>initParam.userName ---> </span>
      <c:out value="${initParam.userName}" />
    </div>
  </div>
</body>
</html>