<!DOCTYPE html>
<%@page import="com.database.Haber"%>
<%@page import="com.database.Duyuru"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Dictionary"%>
<%@page import="java.util.Hashtable"%>
<%@page import="java.util.Enumeration"%>

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
                    <h1 class="page-header">Tum Haberler</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <!-- /.panel-heading -->
                        <div class="">
                         <table class="table table-hover">
						      <thead>
						        <tr>
						          <th>Baslik</th>
						          <th>Yayinlanma Zamani</th>
						          <th></th>
						        </tr>
						      </thead>
						      <tbody>
						      <%
		                        	List<Haber> haberler = (List<Haber>) request.getAttribute("haberler");
		                        	for(Haber d:haberler) {
										out.println("<tr>");
		                        		out.println("<td><i>" + d.getBaslik() + "</i></td>");
		                        		out.println("<td><i>" + d.getZaman() + "</i></td>");
										out.println("<td>");
										out.print("<a href='habergoruntuleservlet?id=" + d.getId() + "' class='btn btn-success'>Goruntule</a> &nbsp;");
										out.print("<a href='haberduzenleformservlet?id=" + d.getId() + "' class='btn btn-warning'>Duzenle</a> &nbsp;");
										out.print("<a href='habersilservlet?id=" + d.getId() + "' class='btn btn-danger'>Sil</a>");
										out.println("</td>");
										out.println("</tr>");
		                        	}			
								%>
						      </tbody>
						    </table>
                        	
                        
                        
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