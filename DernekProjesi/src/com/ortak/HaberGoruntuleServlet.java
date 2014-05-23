package com.ortak;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.database.Haber;
import com.database.HaberDatabase;

/**
 * Servlet implementation class HaberGoruntuleServlet
 */
@WebServlet("/habergoruntule")
public class HaberGoruntuleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HaberGoruntuleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		String id = request.getParameter("id");
		HaberDatabase db = new HaberDatabase();
		Haber haber;
		try {
			ArrayList<Haber> son_haberler = (ArrayList<Haber>)db.tumHaberler(3);
			haber = db.haberGoruntule(id);
			request.setAttribute("haber", haber);
			request.setAttribute("son_haberler", son_haberler);
			request.getRequestDispatcher("default/habergoruntule.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
