package com.main;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/kayitservlet")
public class KayitOlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseClass db = new DatabaseClass();
		String name, lastname, username, email, password, birthday, photo;
		String[] checkbox; 
		
		name = request.getParameter("name");
		lastname = request.getParameter("lastname");
		username = request.getParameter("username");
		email = request.getParameter("email");
		password = request.getParameter("password");
		checkbox = request.getParameterValues("checkbox");
		birthday = request.getParameter("dogum_tarihi");
		photo = request.getParameter("photo");
		
		
		if (checkbox != null) {
			try {
				db.AddDatabase(name, lastname, username, email, password, "1", birthday, photo);
			} catch (ClassNotFoundException e) {	
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			try {
				db.AddDatabase(name, lastname, username, email, password, "0", birthday, photo);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

}
