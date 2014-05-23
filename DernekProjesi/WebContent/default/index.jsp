<!DOCTYPE html>
	<%@page import="java.util.List"%>
	<%@page import="com.database.Duyuru" %>
	<%@page import="com.database.Haber" %>
	<%@page import="com.ortak.Fonksiyonlarim" %>
<head>
		<%@include file="/default/includes/header.jsp" %>
	</head>
    <body>
		<%@include file="/default/includes/navbar.jsp" %>
        
        <!-- Homepage Slider -->
        <div class="homepage-slider">
        	<div id="sequence">
				<ul class="sequence-canvas">
					<!-- Slide 1 -->
					<li class="bg4">
						<!-- Slide Title -->
						<h2 class="title">Responsive</h2>
						<!-- Slide Text -->
						<h3 class="subtitle">It looks great on desktops, laptops, tablets and smartphones</h3>
						<!-- Slide Image -->
						<img class="slide-img" src="default/img/homepage-slider/slide1.png" alt="Slide 1" />
					</li>
					<!-- End Slide 1 -->
					<!-- Slide 2 -->
					<li class="bg3">
						<!-- Slide Title -->
						<h2 class="title">Color Schemes</h2>
						<!-- Slide Text -->
						<h3 class="subtitle">Comes with 5 color schemes and it's easy to make your own!</h3>
						<!-- Slide Image -->
						<img class="slide-img" src="default/img/homepage-slider/slide2.png" alt="Slide 2" />
					</li>
					<!-- End Slide 2 -->
					<!-- Slide 3 -->
					<li class="bg1">
						<!-- Slide Title -->
						<h2 class="title">Feature Rich</h2>
						<!-- Slide Text -->
						<h3 class="subtitle">Huge amount of components and over 30 sample pages!</h3>
						<!-- Slide Image -->
						<img class="slide-img" src="default/img/homepage-slider/slide3.png" alt="Slide 3" />
					</li>
					<!-- End Slide 3 -->
				</ul>
				<div class="sequence-pagination-wrapper">
					<ul class="sequence-pagination">
						<li>1</li>
						<li>2</li>
						<li>3</li>
					</ul>
				</div>
			</div>
        </div>
        <!-- End Homepage Slider -->

		<!-- Call to Action Bar -->
	    <div class="section section-white">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="calltoaction-wrapper" style="text-align:left">
							<h3 style="color:brown"><i>Dernek Ile Ilgili Son Haberler</i></h3>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- End Call to Action Bar -->
		
		
		<!--  Duyurularimiz -->
		<% List<Duyuru> duyurular = (List<Duyuru>)request.getAttribute("duyurular"); %>
		<% List<Haber> haberler = (List<Haber>)request.getAttribute("haberler"); %>
		<!-- Press Coverage -->
        <div class="section">
	    	<div class="container">
				<div class="row">
				<% for(Haber h : haberler){ %>
					<div class="col-md-4 col-sm-6">
						<div class="portfolio-item">
							<div class="portfolio-image">
								<a href="page-portfolio-item.html"><img src="default/img/portfolio2.jpg" alt="Project Name"></a>
							</div>
							<div class="portfolio-info">
								<ul>
									<li class="portfolio-project-name"><%= Fonksiyonlarim.removeHTML(h.getBaslik()) %></li>
									<li><%= Fonksiyonlarim.removeHTML(h.getIcerik()) %></li>
									<li>Zaman: <%= h.getZaman() %></li>
									<li class="read-more"><a href="habergoruntule?id=<%=h.getId() %>" class="btn">Haberi Goruntule</a></li>
								</ul>
							</div>
						</div>
					</div>
				<% } %>
				</div>
			</div>
		</div>
		
		
		<!-- Call to Action Bar -->
	    <div class="section section-white">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="calltoaction-wrapper" style="text-align:left">
							<h3 style="color:brown"><i>Dernek Ile Ilgili Duyurular</i></h3>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- End Call to Action Bar -->
		
		
		<div class="section">
	    	<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="products-slider">
							<!-- Products Slider Item -->
							<% for(Duyuru d : duyurular){ %>
							<div class="shop-item">
								<!-- Product Image -->
								<div class="image">
									<a href="page-product-details.html"><img src="default/img/product1.jpg" alt="Item Name"></a>
								</div>
								<!-- Product Title -->
								<div class="title">
									<h3><a href="page-product-details.html"><%= d.getBaslik() %></a></h3>
								</div>
								<!-- Product Price -->
								<div class="price">
									<% if(Fonksiyonlarim.removeHTML(d.getIcerik()).length() > 20){ %>
										<%= Fonksiyonlarim.removeHTML(d.getIcerik()).subSequence(0, 20)%> ..
									<% } else{%>
										<%= Fonksiyonlarim.removeHTML(d.getIcerik())%> ..
									<% } %>.
								</div>
								<!-- Buy Button -->
								<div class="actions">
									<a href="duyurugoruntuleservlet?id=<%= d.getId() %>" class="btn btn-small"><i class="icon-shopping-cart icon-white"></i>Duyuruyu Goruntule</a>
								</div>
							</div>
							<% } %>
						</div>
					</div>
				</div>
			</div>
	    </div>
		<%@include file="/default/includes/footer.jsp" %>
    </body>
</html>