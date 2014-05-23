<%@page import="com.ortak.Fonksiyonlarim"%>
<%@page import="com.database.Duyuru" %>
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
 <% Duyuru duyuru = (Duyuru)request.getAttribute("duyuru"); %>
 <% List<Duyuru> son_duyurular = (List<Duyuru>)request.getAttribute("son_duyurular"); %>
 <!-- Page Title -->
		<div class="section section-breadcrumbs">
			<div class="container">
				<div class="row">
					<div class="col-sm-12">
						<h1>Duyuru Goruntuleme</h1>
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
								<a href="#"><img src="default/img/portfolio2.jpg" alt="Duyuru Goruntuleme"></a>
							</div>
						</div>
					</div>
					<!-- End Image Column -->
					<!-- Project Info Column -->
					<div class="portfolio-item-description col-sm-6">
						<h3><%= duyuru.getBaslik() %></h3>
						<%= duyuru.getIcerik() %>
						<ul class="no-list-style">
							<li><b>Zaman:</b> <%= duyuru.getZaman() %></li>
						</ul>
					</div>
					<!-- End Project Info Column -->
				</div>
				<!-- Related Projects -->
				<h3>Son Duyurular</h3>
				<div class="row">
					<% for(Duyuru d : son_duyurular){ %>
					<div class="col-md-4 col-sm-6">
						<div class="portfolio-item">
							<div class="portfolio-image">
								<a href="#"><img src="default/img/portfolio3.jpg" alt="Project Name"></a>
							</div>
							<div class="portfolio-info-fade">
								<ul>
									<li class="portfolio-project-name"><%= Fonksiyonlarim.removeHTML(d.getBaslik()) %></li>
									<li><%= Fonksiyonlarim.removeHTML(d.getIcerik()) %></li>
									<li>Zaman: <%= d.getZaman() %></li>
									<li class="read-more"><a href="duyurugoruntuleservlet?id=<%=d.getId() %>" class="btn">Duyuruyu Goruntule</a></li>
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