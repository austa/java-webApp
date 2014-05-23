<!DOCTYPE html>
<%@page import="com.database.Duyuru"%>
<html>

<head>
    	<%@include file="/admin/includes/header.jsp" %>
    	<%@include file="/admin/includes/baseUrl.jsp" %>
</head>

<body>

	 <div id="wrapper">
    	<%@include file="/admin/includes/navbar.jsp" %>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">
						<% Duyuru duyuru = (Duyuru)request.getAttribute("duyuru"); %>
                      	<%= duyuru.getBaslik() %>
					                        		
					</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	<fieldset>
                        		<%= duyuru.getIcerik() %>
                        		  <br><br>
                        		  Yayinlanma Zamani : <%= duyuru.getZaman() %>
                        	</fieldset>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-8 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    	<%@include file="/admin/includes/footer.jsp" %>

</body>

</html>