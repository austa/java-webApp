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

/**
 * Servlet implementation class DuyuruGoruntule
 */
@WebServlet("/duyurugoruntuleservlet")
public class DuyuruGoruntuleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DuyuruGoruntuleServlet() {
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
		DuyuruDatabase db = new DuyuruDatabase();
		Duyuru duyuru;
		try {
			ArrayList<Duyuru> son_duyurular = (ArrayList<Duyuru>)db.tumDuyurular(3);
			duyuru = db.duyuruGoruntule(id);
			request.setAttribute("duyuru", duyuru);
			request.setAttribute("son_duyurular", son_duyurular);
			request.getRequestDispatcher("default/duyurugoruntule.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
