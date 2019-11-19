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
 * Servlet implementation class AjouterArticle
 */
@WebServlet("/AjouterArticle")
public class AjouterArticleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterArticleController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String p = request.getParameter("prix");
		Article article = new Article(nom, Double.parseDouble(p));
		
		HttpSession session = request.getSession();
		Panier panier = (Panier) session.getAttribute("panier");
		
		panier.ajouter(article);
		List<Article> articles = panier.getArticles();
		
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
