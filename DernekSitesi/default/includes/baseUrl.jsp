<%@page import="java.net.URL"%>
<%


URL base =  new URL(request.getScheme(), 
	        request.getServerName(), 
	        request.getServerPort(), 
	        request.getContextPath());
String baseUrl = base.toString();
%>