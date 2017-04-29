package controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import beans.idea;
import dao.ideasDao;

/**
 * Servlet implementation class GestionIdeas
 */
@WebServlet("/GestionIdeas")
public class GestionIdeas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("je suis dans doGet de GestionIdeas. >0<");
			
		List<idea> lu = ideasDao.findAll();
		System.out.println("ideasDao.findall fini. >0<");
		String action = request.getParameter("action");
		if (action != null) {
			String idCh = request.getParameter("id");
			if (idCh != null) {
				try {
				} catch (Exception e) {

				}
			}

			if (action.equals("supprimer")) {
			//	UtilisateursDao.delete(id);
			} else if (action.equals("modifier")) {
			//	request.setAttribute("uModif", UtilisateursDao.find(id));
			} else if (action.equals("sort")) {
				// ordina la lista implicitamente utilizzando il metodo
				// compareTo dell'interfaccia Comparable (vedere la classe
				// Users)
				
				
				//????faut faire un nv comparator
				//Collections.sort(lu);
			}
		}

		// recuperer une liste d'utilisateurs

		request.setAttribute("listeIdeas", lu);
		System.out.println("serAttribute fini. >0<");
		// rediriger vers une page
		request.getRequestDispatcher("page_accueil.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
