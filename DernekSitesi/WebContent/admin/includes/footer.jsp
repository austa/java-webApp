<%@page import="java.net.URL"%>
<%


URL baseFooter =  new URL(request.getScheme(), 
	        request.getServerName(), 
	        request.getServerPort(), 
	        request.getContextPath());
String baseUrlFooter = baseFooter.toString() + "/admin";
%>

    <script src="<%= baseUrlFooter %>/js/jquery-1.10.2.js"></script>
    <script src="<%= baseUrlFooter %>/js/bootstrap.min.js"></script>
    <script src="<%= baseUrlFooter %>/js/plugins/metisMenu/jquery.metisMenu.js"></script>

    <!-- Page-Level Plugin Scripts - Dashboard -->
    <script src="<%= baseUrlFooter %>/js/plugins/morris/raphael-2.1.0.min.js"></script>
    <script src="<%= baseUrlFooter %>/js/plugins/morris/morris.js"></script>

    <!-- SB Admin Scripts - Include with every page -->
    <script src="<%= baseUrlFooter %>/js/sb-admin.js"></script>

    <!-- Page-Level Demo Scripts - Dashboard - Use for reference -->
    <script src="<%= baseUrlFooter %>/js/demo/dashboard-demo.js"></script>