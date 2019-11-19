package fr.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.entity.Article;
import fr.entity.Panier;

/**
 * Servlet implementation class AfficherArtcles
 */
@WebServlet("/AfficherPanier")
public class AfficherPanierController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AfficherPanierController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String button = request.getParameter("button");
		HttpSession session = request.getSession();
		Panier panier = (Panier)session.getAttribute("panier");

		Article articleAretirer = panier.findByIntitue(button);

		List<Article> articles = panier.getArticles();

		if (articleAretirer != null) {
			panier.retirer(articleAretirer);
		}
		System.out.println(button);

		session.setAttribute("articles", articles);

		getServletContext().getRequestDispatcher("/afficherPanier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
