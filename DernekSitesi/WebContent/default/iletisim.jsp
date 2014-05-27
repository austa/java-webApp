<!DOCTYPE html>
	<head>	
		<%@include file="/default/includes/header.jsp" %>
	</head>
    <body>
		<%@include file="/default/includes/navbar.jsp" %>
        <!-- Page Title -->
		<div class="section section-breadcrumbs">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<h1>Iletisim</h1>
					</div>
				</div>
			</div>
		</div>
        
        <div class="section">
	    	<div class="container">
	        	<div class="row">
	        		<div class="col-sm-7">
	        			<!-- Map -->
	        			<div>
							<iframe width="625" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=tr&amp;geocode=&amp;q=19+May%C4%B1s+%C3%9Cniversitesi,+Samsun,+T%C3%BCrkiye&amp;aq=0&amp;oq=19+may%C4%B1s+%C3%BCniver&amp;sll=37.0625,-95.677068&amp;sspn=40.681389,86.572266&amp;t=m&amp;ie=UTF8&amp;hq=19+May%C4%B1s+%C3%9Cniversitesi,+Samsun,+T%C3%BCrkiye&amp;ll=41.365798,36.199318&amp;spn=0.027699,0.053298&amp;output=embed"></iframe><br /><small><a href="https://maps.google.com/maps?f=q&amp;source=embed&amp;hl=tr&amp;geocode=&amp;q=19+May%C4%B1s+%C3%9Cniversitesi,+Samsun,+T%C3%BCrkiye&amp;aq=0&amp;oq=19+may%C4%B1s+%C3%BCniver&amp;sll=37.0625,-95.677068&amp;sspn=40.681389,86.572266&amp;t=m&amp;ie=UTF8&amp;hq=19+May%C4%B1s+%C3%9Cniversitesi,+Samsun,+T%C3%BCrkiye&amp;ll=41.365798,36.199318&amp;spn=0.027699,0.053298" style="color:#0000FF;text-align:left">Daha Büyük Görüntüle</a></small>
	        			</div>
	        			<!-- End Map -->
	        			<!-- Contact Info -->
	        			<p class="contact-us-details">
	        				<b>Adres:</b> 19 Mayis Universitesi Muhendislik Fakultesi<br/> Atakum/SAMSUN<br/>
	        				<b>Telefon:</b> 03624371919<br/>
	        				<b>Email:</b> <a href="mailto:alaattin.usta@bil.omu.edu.tr">alaattin.usta@bil.omu.edu.tr</a>
	        			</p>
	        			<!-- End Contact Info -->
	        		</div>
	        		<div class="col-sm-5">
	        			<!-- Contact Form -->
	        			<h3>Bize Yazin</h3>
	        			<div class="contact-form-wrapper">
		        			<form class="form-horizontal" role="form">
		        				 <div class="form-group">
		        				 	<label for="Name" class="col-sm-3 control-label"><b>Isminiz</b></label>
		        				 	<div class="col-sm-9">
										<input class="form-control" id="Name" type="text" placeholder="">
									</div>
								</div>
								<div class="form-group">
									<label for="contact-email" class="col-sm-3 control-label"><b>Email Adresiniz</b></label>
									<div class="col-sm-9">
										<input class="form-control" id="contact-email" type="text" placeholder="">
									</div>
								</div>
								<div class="form-group">
									<label for="contact-message" class="col-sm-3 control-label"><b>Mesaj</b></label>
									<div class="col-sm-9">
										<textarea class="form-control" rows="5" id="contact-message"></textarea>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-12">
										<button type="submit" class="btn pull-right">Gonder</button>
									</div>
								</div>
		        			</form>
		        		</div>
		        		<!-- End Contact Info -->
	        		</div>
	        	</div>
	    	</div>
	    </div>
		<%@include file="/default/includes/footer.jsp" %>
	</body>
</html>