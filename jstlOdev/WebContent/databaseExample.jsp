<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Veri Tabanı İçerik Görüntüleme</title>
</head>
<body>
<center>
	<h3>Veri Tabanındaki İsimler</h3>
	<sql:setDataSource
	var="database" 
	driver="com.mysql.jdbc.Driver" 
	url="jdbc:mysql://localhost/database" 
	user="root" password="aletbaba53" />
	
	<sql:query dataSource="${database}" 
	sql="SELECT * FROM employees"  
	var="employees" />
	<UL>
		<c:forEach var="row" items="${employees.rows}">
			<LI>${row.name} ${row.lastname}
		</c:forEach>	
	</UL>
</center>
</body>
</html>