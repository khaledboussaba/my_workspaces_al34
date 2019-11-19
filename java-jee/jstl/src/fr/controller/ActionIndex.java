package fr.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ActionIndex implements Action{

	@Override
	public String queFaire(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> cours = new ArrayList<String>();
		cours.add("Java");
		cours.add("Struts");
		cours.add("Jee");
		cours.add("Uml");
		cours.add("Xml");
		cours.add("Angular");
		HttpSession session = request.getSession();
		session.setAttribute("lesCours", cours);
		return "/saisie.jsp";
	}

}
