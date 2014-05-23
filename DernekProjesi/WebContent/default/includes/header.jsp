<%@page import="java.net.URL"%>
<%
URL baseHeader =  new URL(request.getScheme(), 
	        request.getServerName(), 
	        request.getServerPort(), 
	        request.getContextPath());
String baseUrlHeader = baseHeader.toString() + "/default";
%>
    
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>mPurpose - Multipurpose Feature Rich Bootstrap Template</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">

        <link rel="stylesheet" href="<%= baseUrlHeader %>/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%= baseUrlHeader %>/css/icomoon-social.css">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,600,800' rel='stylesheet' type='text/css'>

        <link rel="stylesheet" href="<%= baseUrlHeader %>/css/leaflet.css" />
		<!--[if lte IE 8]>
		    <link rel="stylesheet" href="css/leaflet.ie.css" />
		<![endif]-->
		<link rel="stylesheet" href="<%= baseUrlHeader %>/css/main.css">

        <script src="<%= baseUrlHeader %>/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>