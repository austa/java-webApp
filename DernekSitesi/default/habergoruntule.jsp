<%@page import="com.ortak.Fonksiyonlarim"%>
<%@page import="com.database.Haber" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/default/includes/header.jsp" %>
</head>
<body>
<%@include file="/default/includes/navbar.jsp" %>
 <% Haber haber = (Haber)request.getAttribute("haber"); %>
 <% List<Haber> son_haberler = (List<Haber>)request.getAttribute("son_haberler"); %>
 <!-- Page Title -->
		<div class="section section-breadcrumbs">
			<div class="container">
				<div class="row">
					<div class="col-sm-12">
						<h1>Haber Goruntuleme</h1>
					</div>
				</div>
			</div>
		</div>
        
        <div class="section">
	    	<div class="container">
				<div class="row">
					<!-- Image Column -->
					<div class="col-sm-6">
						<div class="portfolio-item">
							<div class="portfolio-image">
								<a href="#"><img src="images/<%= haber.getResim() %>" alt="Duyuru Goruntuleme"></a>
							</div>
						</div>
					</div>
					<!-- End Image Column -->
					<!-- Project Info Column -->
					<div class="portfolio-item-description col-sm-6">
						<h3><%= haber.getBaslik() %></h3>
						<%= haber.getIcerik() %>
						<ul class="no-list-style">
							<li><b>Zaman:</b> <%= haber.getZaman() %></li>
						</ul>
					</div>
					<!-- End Project Info Column -->
				</div>
				<!-- Related Projects -->
				<h3>Son Haberler</h3>
				<div class="row">
					<% for(Haber h : son_haberler){ %>
					<div class="col-md-4 col-sm-6">
						<div class="portfolio-item">
							<div class="portfolio-image">
								<a href="#"><img src="images/<%= h.getResim() %>" alt="Project Name"></a>
							</div>
							<div class="portfolio-info-fade">
								<ul>
									<li class="portfolio-project-name"><%= Fonksiyonlarim.removeHTML(h.getBaslik()) %></li>
									<li><%= Fonksiyonlarim.removeHTML(h.getIcerik()) %></li>
									<li>Zaman: <%= h.getZaman() %></li>
									<li class="read-more"><a href="habergoruntule?id=<%= h.getId() %>" class="btn">Haberi Goruntule</a></li>
								</ul>
							</div>
						</div>
					</div>
					<% } %>
				</div>
				<!-- End Related Projects -->
			</div>
		</div>
	<%@include file="/default/includes/footer.jsp" %>
	</body>
</html>