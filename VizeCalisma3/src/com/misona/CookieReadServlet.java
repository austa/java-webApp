package com.misona;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieReadServlet
 */
@WebServlet("/cookiereadservlet")
public class CookieReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookie = request.getCookies();
		boolean newbie = true;
		if (cookie != null) {
			for (Cookie myCookie : cookie) {
				if ((myCookie.getValue().equals("alaattin")) && myCookie.getValue() != null) {
					newbie = false;					
				}
			}
		}
		String title = "";
		
		if (newbie) {
			Cookie myCookie = new Cookie("username", "alaattin");
			myCookie.setMaxAge(60*60*24*3);
			response.addCookie(myCookie);
			title = "Aboard Welcome";
		}else {
			title = "Welcome Back";
		}
		
		response.getWriter().write(title);
	}

}
