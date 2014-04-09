<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>İller </title>
</head>
<body>
	<center><H2>İller</H2>
		<UL>
			<c:forEach var="il" items="${iller}">
				<LI>${il}
			</c:forEach>
		</UL>
	</center>	
</body>
</html>