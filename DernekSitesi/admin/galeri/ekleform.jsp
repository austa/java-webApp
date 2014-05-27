<!DOCTYPE html>
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
                    <h1 class="page-header">Galeri Ekle</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	<form action="<%=baseUrl %>/admin/galeriekleservlet" method="post">
		                        <div class="form-group">
		                            <label>Galeri Ismi</label>
		                            <input class="form-control" name="isim" placeholder="Lutfen Haber Basligini Giriniz" required>
		                        </div>
	                        	<div class="form-group">
		                         		<input type="submit" value="Galeriyi Ekle" class="btn btn-primary btn-lg"/>
							  	</div>
						  	</form>
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

		<script src="http://js.nicedit.com/nicEdit-latest.js" type="text/javascript"></script>
		<script type="text/javascript">bkLib.onDomLoaded(nicEditors.allTextAreas);</script>



    	<%@include file="/admin/includes/footer.jsp" %>

</body>

</html>