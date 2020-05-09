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

 
    <form method="post" action="${pageContext.request.contextPath}/uploadFile"
        enctype="multipart/form-data">
        
        <font size="5" color="black" face="Arial">Выберите архив:</font>
<br>
<br>
        <input type="file" name="file"  />
<br>
<br>
        <font size="3" color="black" face="Arial"><input type="submit" value="Загрузить архив" /></font>
    </form>
    
</body>
</html>