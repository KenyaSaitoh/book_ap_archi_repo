<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<title>PersonUpdatePage</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
  <h2>PersonUpdatePage</h2>
  <hr />
  <form method="POST">
    <div ${person.personId == null ? 'style="display:none"' : ''}>
      <span>ID : ${person.personId}</span>
    </div>
    <table border="0">
      <tr>
        <td>名前</td>
        <td>${fn:escapeXml(person.personName)}</td>
        <%-- または以下のようにしてエスケープする
             <c:out value="${person.personName}" escapeXml="true" />
              --%>
      </tr>
      <tr>
        <td>年齢</td>
        <td>${person.age}</td>
      </tr>
      <tr>
        <td>性別</td>
        <td>${person.gender == null ? '' : person.gender == 'male' ? '男性' : '女性'}</td>
      </tr>
    </table>
    <div>
      <button type="submit" formaction="/spring_mvc_person/back">戻る</button>
      <button type="submit" formaction="/spring_mvc_person/update">更新実行</button>
    </div>
  </form>
</body>
</html>