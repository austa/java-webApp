<%@page import="java.net.URL"%>
<%
URL baseLeftMenu =  new URL(request.getScheme(), 
	        request.getServerName(), 
	        request.getServerPort(), 
	        request.getContextPath());
String baseUrlLeftMenu = baseLeftMenu.toString() + "/admin";
%>

<div class="navbar-default navbar-static-side" role="navigation">
       <div class="sidebar-collapse">
           <ul class="nav" id="side-menu">
               <li>
                   <a href="<%=baseUrlLeftMenu%>"><i class="fa fa-dashboard fa-fw"></i> Anasayfa</a>
               </li>
               <li>
                   <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>Duyurular<span class="fa arrow"></span></a>
                   <ul class="nav nav-second-level">
                       <li>
                           <a href="<%=baseUrlLeftMenu%>/duyuru/ekleform.jsp">Yeni Ekle</a>
                       </li>
                       <li>
                           <a href="<%=baseUrlLeftMenu%>/duyurularservlet">Tümünü Görüntüle</a>
                       </li>
                   </ul>
                   <!-- /.nav-second-level -->
               </li>
               <li>
                   <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>Haberler<span class="fa arrow"></span></a>
                   <ul class="nav nav-second-level">
                       <li>
                           <a href="<%=baseUrlLeftMenu%>/haber/ekleform.jsp">Yeni Ekle</a>
                       </li>
                       <li>
                           <a href="<%=baseUrlLeftMenu%>/haberlerservlet">Tümünü Görüntüle</a>
                       </li>
                   </ul>
                   <!-- /.nav-second-level -->
               </li>
               
               <li>
                   <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>Galeri<span class="fa arrow"></span></a>
                   <ul class="nav nav-second-level">
                       <li>
                           <a href="<%=baseUrlLeftMenu%>/galeri/ekleform.jsp">Yeni Ekle</a>
                       </li>
                       <li>
                           <a href="<%=baseUrlLeftMenu%>/galerilerservlet">Tümünü Görüntüle</a>
                       </li>
                   </ul>
                   <!-- /.nav-second-level -->
               </li>
				<li>
                   <a href="index.html"><i class="fa fa-dashboard fa-fw"></i> Cikis Yap</a>
               </li>
               
           </ul>
           <!-- /#side-menu -->
       </div>
       <!-- /.sidebar-collapse -->
   </div>
   <!-- /.navbar-static-side -->