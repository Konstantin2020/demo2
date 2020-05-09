<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE >
<html>
<head>
<title>Выбор архива</title>
</head>
<body>
 
    <div style="padding:5px; color:red;font-style:italic;">
       ${errorMessage}
    </div>
    
    <h2>Выбор архива</h2>
 
    <form method="post" action="${pageContext.request.contextPath}/uploadFile"
        enctype="multipart/form-data">
        
        Выберите архив:
        <br />
        <input type="file" name="file"  />
        <br />
        <input type="submit" value="Загрузить" />
    </form>
    
</body>
</html>