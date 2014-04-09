package com.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginkontrol")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestUsername = (String) request.getParameter("username");
		String requestValue = (String) request.getParameter("password");

		String cookieUsername = requestUsername+"_name";
		String cookieValue = requestUsername+"_value";
		String cookieTotal = requestUsername+"_total";
		
		boolean newbie = true;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getValue().equals(requestUsername) && cookie.getName().equals(cookieUsername)) {
					newbie = false;
					break;
				} 
			}
			if(!newbie){
				for(Cookie cookie: cookies) {
					if (cookieTotal.equals(cookie.getName())) {
						Integer total = Integer.parseInt(cookie.getValue())+1;
						cookie.setValue(total.toString());
						response.addCookie(cookie);
					}
				}
			}
		}
		if (newbie) {
			Cookie Username = new Cookie(cookieUsername, requestUsername);
			Username.setMaxAge(60*60*24*3);
			response.addCookie(Username);

			Cookie Value = new Cookie(cookieValue, requestValue);
			Value.setMaxAge(60*60*24*3);
			response.addCookie(Value);
			
			Cookie Total = new Cookie(cookieTotal, "1");
			Total.setMaxAge(60*60*24*3);
			response.addCookie(Total);
		}
		if(requestUsername.equals("admin") && requestValue.equals("1234"))
		{
			response.sendRedirect("index?username="+requestUsername);
		}
		else{
			response.sendRedirect("guest?username="+requestUsername);
		}
	}
}
