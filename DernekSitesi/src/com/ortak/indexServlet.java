package com.ortak;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.Duyuru;
import com.database.DuyuruDatabase;
import com.database.Haber;
import com.database.HaberDatabase;

/**
 * Servlet implementation class indexServlet
 */
@WebServlet("/indexservlet")
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DuyuruDatabase duyuruDb = new DuyuruDatabase();
		HaberDatabase haberDb = new HaberDatabase();
		ArrayList<Duyuru> duyurular;
		try {
			ArrayList<Haber> haberler = (ArrayList <Haber>)haberDb.tumHaberler(6);
			duyurular = (ArrayList <Duyuru>)duyuruDb.tumDuyurular(12);
			request.setAttribute("haberler", haberler);
			request.setAttribute("duyurular", duyurular);
			request.getRequestDispatcher("/default/index.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
