package com.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/guest")
public class Guest extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Cookie[] cookies = request.getCookies();
		String username = null;
		String value = null;
		String total = null;
		
		String requestUsername = request.getParameter("username");
		String cookieUsername = requestUsername+"_name";
		String cookieValue = requestUsername+"_value";
		String cookieTotal = requestUsername+"_total";
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals(cookieUsername)){
					username = cookie.getValue();
				}
				if(cookie.getName().equals(cookieValue)){
					value = cookie.getValue();
				}
				if(cookie.getName().equals(cookieTotal)){
					total = cookie.getValue();
				}
			}
		}
		
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
			      "Transitional//EN\">\n";
		PrintWriter out = response.getWriter();
		out.println(docType +
				"<HTML>\n" +
				"<HEAD><TITLE>" + "Uye Sayfasi" +"</TITLE>"+ 
				"</HEAD>\n" +
				"<BODY background=" + "./image/arkaplan.jpg>\n"+
				"<CENTER>\n" +
				"<H1>" + "Sayin üyemiz sistemimize hosgeldiniz" + "</H1>\n" +
				"<H1>" + "\n Kullanici Adi = "+username + "</H1>\n" +
				"<H1>" + "\n Sifre = "+value + "</H1>\n" +
				"<H1>" + "\n Giris Sayisi = "+total + "</H1>\n" +
				"</CENTER>"
				+ "</BODY>"
				+ "</HTML>");
	}

}
