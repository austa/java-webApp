package com.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ornekservlet")
public class OrnekServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] sehirler = {"Corum", "Bartın", "Rize", "Bursa", "Samsun", "Konya", "Yalova", "İstanbul", "Manisa", "Kars"};
		request.setAttribute("iller", sehirler);
		String address = "goruntule.jsp";
		request.getRequestDispatcher(address).forward(request, response);

	}

}
