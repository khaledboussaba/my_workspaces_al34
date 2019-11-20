package fr.bean;

public class Article {
	
	private int id;
	private String nom;
	private double prix;
	private String description;
	
	public Article(int id, String nom, double prix, String description) {
		setId(id);
		setNom(nom);
		setPrix(prix);
		setDescription(description);
	}
	
	@Override
	public String toString() {
		return nom + " " + prix + " " + description;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}