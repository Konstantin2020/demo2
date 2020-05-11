<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Обработка заявок</title>
<style>
   a { 
    text-decoration: none; /* Отменяем подчеркивание у ссылки */
   } 
  </style>
</head>
<body>
<font size="6" color="black" face="Arial">Сервис обработки заявок</font>
<!--<c:out value="${12+56*2+2}" />-->

<!-- <p><font color="red"><c:out value="${create_bool}" default="База не создана" /></font></p> -->
<c:if test="${create_DB_bool == null}">
	<p><font size="5" color="blue" face="Arial"><a href='<c:url value="/main" />'>Создание очереди и подготовка базы данных в памяти</a></font></p>
    <p><font size="4" color="red" face="Arial">База даных для хранения обработанных заявок не создана</font></p>
    <p><font size="4" color="red" face="Arial">Очередь для занесения заявок перед обработкой не создана</font></p>
</c:if>
<c:if test="${create_DB_bool&&create_DQ_bool}">
	<p><font size="5" color="#c0c0c0" face="Arial">Создание очереди и подготовка базы данных в памяти</font></p>
    <p><font size="4" color="green" face="Arial">База для хранения обработанных заявок создана</font></p>
    <p><font size="4" color="green" face="Arial">Очередь для занесения заявок перед обработкой создана</font></p>
</c:if>
<!--<c:if test="${create_DQ_bool == null}">
    <p><font size="4" color="red" face="Arial">Очередь для занесения заявок перед обработкой не создана</font></p>
</c:if>
<c:if test="${create_DQ_bool}">
    <p><font size="4" color="green" face="Arial">Очередь для занесения заявок перед обработкой создана</font></p>-->
			<!-- <p><a href='<c:url value="/admincontrol" />'>Панель контроля</a></p> -->
					
			<c:if test="${fileSourceName_int == null}">
				<p><font size="5" color="blue" face="Arial"><a href='<c:url value="/uploadFile" />'>Выбрать архив с файлами - источниками данных</a></font></p>
			   	<p><font size="4" color="red" face="Arial">Архив с файлами-источниками данных не выбран</font></p>
			</c:if>
			<c:if test="${fileSourceName_int == 1}">
				<p><font size="5" color="blue" face="Arial"><a href='<c:url value="/uploadFile" />'>Выбрать архив с файлами - источниками данных</a></font></p>
			    <p><font size="4" color="red" face="Arial">Архив с файлами-источниками данных не выбран, повторите попытку</font></p>
			</c:if>
			<c:if test="${fileSourceName_int==2}">
				<p><font size="5" color="#c0c0c0" face="Arial">Выбрать архив с файлами - источниками данных</font></p>
			    <p><font size="4" color="green" face="Arial">Архив с файлами-источниками данных выбран</font></p>
  			
  			 <!--<c:choose>
  			<c:when test="${insert_Data_To_DB_int==null}">  
			    <p><font size="5" color="blue" face="Arial"><a href='<c:url value="/enterToDB" />'>Внести данные из файлов - источников в базу данных</a></font></p>
			  </c:when>
			  <c:when test="${insert_Data_To_DB_int==0}">  
			    <p><font size="5" color="#c0c0c0" face="Arial">Внести данные из файлов - источников в базу данных</font></p>
			  </c:when>
			  <c:when test="${insert_Data_To_DB_int==1}">  
			    <p><font size="5" color="#c0c0c0" face="Arial">Внести данные из файлов - источников в базу данных</font></p>
			</c:when>
			 </c:choose>-->
			 
			    <p><font size="5" color="blue" face="Arial"><a href='<c:url value="/create" />'>Создать новую заявку</a></font></p>
			         <c:choose>
			    		<c:when test="${create_Request_int==0}">
			    			<p><font size="4" color="red" face="Arial">Заявка не создана</font></p>
			    		</c:when>
			    		<c:when test="${create_Request_int==1}">
			    			<p><font size="4" color="red" face="Arial">Заявка уже существует, либо уже обработана и внесена в базу данных</font></p>
			    			<p><font size="3" color="blue" face="Arial"><a href='<c:url value="/report_1_1" />'>Отчёт 1.1 - вывод состояния обработки очереди заявок (состояние обработчика, заявок всего, заявок обработано, последняя заявка)</a></font></p>
							<p><font size="3" color="blue" face="Arial"><a href='<c:url value="/report_1_2" />'>Отчет 1.2 история заявок, последние 10 заявок (последняя первая в списке)</a></font></p>
							<p><font size="3" color="blue" face="Arial"><a href='<c:url value="/report_2_1" />'>Отчет 2.1 итоговая обработка источников данных (метка, итоговое количество)</a></font></p>
							<p><font size="3" color="blue" face="Arial"><a href='<c:url value="/report_2_2" />'>Отчет 2.2 итоговая обработка источников данных (метка, массив значений, по убыванию)</a></font></p>
							<p><font size="3" color="blue" face="Arial"><a href='<c:url value="/report_2_3" />'>Отчет 2.3 итоговая обработка источников данных согласно подготовленного списка (метка, итоговое количество или null)</a></font></p>		
 		    			</c:when>
			    		<c:when test="${create_Request_int==2}">
			    			<p><font size="4" color="green" face="Arial">Заявка создана</font></p>
			    			<p><font size="3" color="blue" face="Arial"><a href='<c:url value="/report_1_1" />'>Отчёт 1.1 - вывод состояния обработки очереди заявок (состояние обработчика, заявок всего, заявок обработано, последняя заявка)</a></font></p>
							<p><font size="3" color="blue" face="Arial"><a href='<c:url value="/report_1_2" />'>Отчет 1.2 история заявок, последние 10 заявок (последняя первая в списке)</a></font></p>
							<p><font size="3" color="blue" face="Arial"><a href='<c:url value="/report_2_1" />'>Отчет 2.1 итоговая обработка источников данных (метка, итоговое количество)</a></font></p>
							<p><font size="3" color="blue" face="Arial"><a href='<c:url value="/report_2_2" />'>Отчет 2.2 итоговая обработка источников данных (метка, массив значений, по убыванию)</a></font></p>
							<p><font size="3" color="blue" face="Arial"><a href='<c:url value="/report_2_3" />'>Отчет 2.3 итоговая обработка источников данных согласно подготовленного списка (метка, итоговое количество или null)</a></font></p>		
 			    		</c:when>
			    		<c:when test="${create_Request_int==3}">
			    			<p><font size="4" color="green" face="Arial">Заявки созданы (количество: <c:out value="${lengthDeQue}"></c:out>)</font></p>
			    			<p><font size="3" color="blue" face="Arial"><a href='<c:url value="/report_1_1" />'>Отчёт 1.1 - вывод состояния обработки очереди заявок (состояние обработчика, заявок всего, заявок обработано, последняя заявка)</a></font></p>
							<p><font size="3" color="blue" face="Arial"><a href='<c:url value="/report_1_2" />'>Отчет 1.2 история заявок, последние 10 заявок (последняя первая в списке)</a></font></p>
							<p><font size="3" color="blue" face="Arial"><a href='<c:url value="/report_2_1" />'>Отчет 2.1 итоговая обработка источников данных (метка, итоговое количество)</a></font></p>
							<p><font size="3" color="blue" face="Arial"><a href='<c:url value="/report_2_2" />'>Отчет 2.2 итоговая обработка источников данных (метка, массив значений, по убыванию)</a></font></p>
							<p><font size="3" color="blue" face="Arial"><a href='<c:url value="/report_2_3" />'>Отчет 2.3 итоговая обработка источников данных согласно подготовленного списка (метка, итоговое количество или null)</a></font></p>		
 			    		</c:when>
			    		<c:when test="${create_Request_int==4}">
			    			<p><font size="4" color="red" face="Arial">Заявка не может быть пустой, повторите ввод</font></p>
			    			<p><font size="3" color="blue" face="Arial"><a href='<c:url value="/report_1_1" />'>Отчёт 1.1 - вывод состояния обработки очереди заявок (состояние обработчика, заявок всего, заявок обработано, последняя заявка)</a></font></p>
							<p><font size="3" color="blue" face="Arial"><a href='<c:url value="/report_1_2" />'>Отчет 1.2 история заявок, последние 10 заявок (последняя первая в списке)</a></font></p>
							<p><font size="3" color="blue" face="Arial"><a href='<c:url value="/report_2_1" />'>Отчет 2.1 итоговая обработка источников данных (метка, итоговое количество)</a></font></p>
							<p><font size="3" color="blue" face="Arial"><a href='<c:url value="/report_2_2" />'>Отчет 2.2 итоговая обработка источников данных (метка, массив значений, по убыванию)</a></font></p>
							<p><font size="3" color="blue" face="Arial"><a href='<c:url value="/report_2_3" />'>Отчет 2.3 итоговая обработка источников данных согласно подготовленного списка (метка, итоговое количество или null)</a></font></p>		
 						</c:when>
			    		</c:choose>
							
			    				  </c:if> 	
			</c:if>
	
	



<br>

</body>
</html>
  