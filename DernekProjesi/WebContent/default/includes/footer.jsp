<%@page import="java.net.URL"%>
<%


URL baseFooter =  new URL(request.getScheme(), 
	        request.getServerName(), 
	        request.getServerPort(), 
	        request.getContextPath());
String baseUrlFooter = baseFooter.toString() + "/default";
%>

	    <!-- Footer -->
	    <div class="footer">
	    	<div class="container">
		    	<div class="row">
		    		<div class="col-footer col-md-3 col-xs-6">
		    			<h3>Dernek Sitesi</h3>
		    			<div class="portfolio-item">
							<div class="portfolio-image">
								<a href=""><img src="<%= baseUrlFooter %>/img/portfolio6.jpg" alt="Project Name"></a>
							</div>
						</div>
		    		</div>
		    		<div class="col-footer col-md-3 col-xs-6">
		    			<h3>Linkler</h3>
		    			<ul class="no-list-style footer-navigate-section">
		    				<li><a href="page-blog-posts.html">Tum Haberler</a></li>
		    				<li><a href="page-portfolio-3-columns-2.html">Tum Duyurular</a></li>
		    				<li><a href="page-products-3-columns.html">Galeri</a></li>
		    				<li><a href="page-services-3-columns.html">Iletisim</a></li>
		    				<li><a href="page-pricing.html">Hakkimizda</a></li>
		    			</ul>
		    		</div>
		    		
		    		<div class="col-footer col-md-4 col-xs-6">
		    			<h3>Iletisim</h3>
		    			<p class="contact-us-details">
	        				<b>Adres:</b> 19 Mayis Universitesi Muhendislik Fakultesi<br/> Kurupelit/SAMSUN<br />
	        				<b>Telefon:</b> 03624371919<br/>
	        				<b>Cep:</b> 05433945453 <br/>
	        				<b>Email:</b> <a href="mailto:alaattin.usta@bil.omu.edu.tr">alaattin.usta@bil.omu.edu.tr</a>
	        			</p>
		    		</div>
		    		<div class="col-footer col-md-2 col-xs-6">
		    			<h3>Sosyal Aglarimiz</h3>
		    			<ul class="footer-stay-connected no-list-style">
		    				<li><a href="#" class="facebook"></a></li>
		    				<li><a href="#" class="twitter"></a></li>
		    				<li><a href="#" class="googleplus"></a></li>
		    			</ul>
		    		</div>
		    	</div>
		    	<div class="row">
		    		<div class="col-md-12">
		    			<div class="footer-copyright">&copy; 2014  Alaattin USTA</div>
		    		</div>
		    	</div>
		    </div>
	    </div>
	    <!-- Javascripts -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/jquery-1.9.1.min.js"><\/script>')</script>
        <script src="<%= baseUrlFooter %>/js/bootstrap.min.js"></script>
        <script src="http://cdn.leafletjs.com/leaflet-0.5.1/leaflet.js"></script>
        <script src="<%= baseUrlFooter %>/js/jquery.fitvids.js"></script>
        <script src="<%= baseUrlFooter %>/js/jquery.sequence-min.js"></script>
        <script src="<%= baseUrlFooter %>/js/jquery.bxslider.js"></script>
        <script src="<%= baseUrlFooter %>/js/main-menu.js"></script>
        <script src="<%= baseUrlFooter %>/js/template.js"></script>
