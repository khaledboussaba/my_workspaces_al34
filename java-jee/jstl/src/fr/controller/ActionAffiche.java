package fr.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.entity.Candidat;

public class ActionAffiche implements Action {

	@Override
	public String queFaire(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String nom = (String) session.getAttribute("nom");
		String prenom = (String) session.getAttribute("prenom");
				
		ArrayList<String> coursSuivis = (ArrayList<String>) session.getAttribute("lesCoursSuivis");
		ArrayList<String> coursASuivre = (ArrayList<String>) session.getAttribute("lesCoursASuivre");
		
		Candidat candidat = new Candidat(nom, prenom, coursSuivis, coursASuivre);
//		for (String string : coursSuivis) {
//			System.out.println(string);
//		}
		session.setAttribute("candidat", candidat);
		return "/candidat.jsp";
	}

}
