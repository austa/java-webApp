package com.main;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/kontrolservlet")
public class KontrolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseClass db = new DatabaseClass();
		response.setContentType("text/html");
		String myEmail = request.getParameter("email");
		String myPassword = request.getParameter("password");
		
		try {
			if ("ogrenci".equals(db.QueryDatabase(myEmail, myPassword))) {
				response.sendRedirect("ogrenciservlet");
			} else if ("ogretmen".equals(db.QueryDatabase(myEmail, myPassword))) {
				response.sendRedirect("hocaservlet");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
