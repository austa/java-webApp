<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>standart balance</title>
</head>
<body>
	<fieldset>
				<legend>Bakiyeniz:</legend>
	
		<ul>

			<li>Ad : ${customer.firstName}</li>

			<li>Soyad : ${customer.lastName}</li>

			<li>ID: ${customer.id}</li>

			<li>Bakiye : $${customer.balance}</li>

		</ul>
	</fieldset>
</body>
</html>