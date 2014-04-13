<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="kayitservlet" method="post">
<table>
	<tr><td>Username: </td><td><input type="text" name="name"></td></tr>	
	<tr><td>Password: </td><td><input type="password" name="password"></td></tr>	
	<tr><td colspan="2"><input type="submit" value="Giriş"></td></tr>

</table>
</form>
<a href="requestservlet">Browser türünü öğrenmek için tıklayınız!</a><br>
<a href="yonlendirservlet">Beni yönlendir adi herif!</a><br>
<a href="cookieservlet">Cookie bilgilerini gör</a><br>
<a href="sessionsil">Güvenli çıkış yap!</a>

<%
	String user_name = (String) request.getSession().getAttribute("kullanici");
%>

<%=user_name %>


</body>
</html>