package fr.entity;

import java.util.ArrayList;

public class Candidat {
	
	private String nom;
	private String prenom;
	private ArrayList<String> coursSuivis = new ArrayList<String>();
	private ArrayList<String> coursASuivre = new ArrayList<String>();
	
	public Candidat() {
	}
	
	public Candidat(String nom, String prenom, ArrayList<String> coursSuivis, ArrayList<String> coursASuivre) {
		this.nom = nom;
		this.prenom = prenom;
		this.coursSuivis = coursSuivis;
		this.coursASuivre = coursASuivre;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public ArrayList<String> getCoursSuivis() {
		return coursSuivis;
	}
	public void setCoursSuivis(ArrayList<String> coursSuivis) {
		this.coursSuivis = coursSuivis;
	}
	public ArrayList<String> getCoursASuivre() {
		return coursASuivre;
	}
	public void setCoursASuivre(ArrayList<String> coursASuivre) {
		this.coursASuivre = coursASuivre;
	}

}
