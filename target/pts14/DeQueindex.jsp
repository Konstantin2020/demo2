<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Заявки необработанные</title>
</head>
<table>
<tr><th>Очередь заявок (необработанных)</th></tr>
<c:forEach var="tttt" items="${dfg}">
 <tr><td>${tttt}</td>
 </tr>
</c:forEach>
</table>
</table>
<p><a href='<c:url value="/index" />'>Вернуться на главную</a></p>
</body>
</html>