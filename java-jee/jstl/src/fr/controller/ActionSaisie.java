package fr.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ActionSaisie implements Action {

	@Override
	public String queFaire(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String[] c = request.getParameterValues("coursSuivis");
		ArrayList<String> lesCoursSuivis = new ArrayList<String>(Arrays.asList(c));
		String[] c1 = request.getParameterValues("autreCours");
		ArrayList<String> lesCoursASuivre = new ArrayList<String>(Arrays.asList(c1));
				
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		
		session.setAttribute("nom", nom);
		session.setAttribute("prenom", prenom);
		session.setAttribute("lesCoursSuivis", lesCoursSuivis);
		session.setAttribute("lesCoursASuivre", lesCoursASuivre);
		return "/affiche.jsp";
	}

}
