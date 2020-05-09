<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Данные для контроля</title>
</head>
<table>
<tr><th>Очередь заявок (необработанных)</th></tr>
<c:forEach var="tttt" items="${ArrDeQue}">
 <tr><td>${tttt}</td>
 </tr>
</c:forEach>
</table>
<table>
<tr><th>Список заявок (обработанных) в базе данных</th></tr>
<c:forEach var="DBpoint" items="${DBaftercalc}">
 <tr><td>${DBpoint}</td>
 </tr>
</c:forEach>
</table>
<p><a href='<c:url value="/console"/>'target="_blank">Консоль базы данных</a></p>
<p><a href='<c:url value="/index" />'>Вернуться на главную</a></p>
</body>
</html>