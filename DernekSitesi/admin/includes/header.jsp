<%@page import="java.net.URL"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%


URL baseHeader =  new URL(request.getScheme(), 
	        request.getServerName(), 
	        request.getServerPort(), 
	        request.getContextPath());
String baseUrlHeader = baseHeader.toString() + "/admin";
%>


<title>Alaattin Usta Dernek Projesi</title>
<!-- Core CSS - Include with every page -->
<link href="<%= baseUrlHeader %>/css/bootstrap.min.css" rel="stylesheet">
<link href="<%= baseUrlHeader %>/font-awesome/css/font-awesome.css" rel="stylesheet">

<!-- Page-Level Plugin CSS - Dashboard -->
<link href="<%= baseUrlHeader %>/css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">
<link href="<%= baseUrlHeader %>/css/plugins/timeline/timeline.css" rel="stylesheet">

<!-- SB Admin CSS - Include with every page -->
<link href="<%= baseUrlHeader %>/css/sb-admin.css" rel="stylesheet">