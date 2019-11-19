package fr.entity;

public class Article {
	
	private String intitule;
	private double prix;
	
	public Article() {
	}

	public Article(String intitule, double prix) {
		setIntitule(intitule);
		setPrix(prix);
	}
	
	public final String getIntitule() {
		return intitule;
	}
	public final void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public final double getPrix() {
		return prix;
	}
	public final void setPrix(double prix) {
		if (prix >= 0) {
			this.prix = prix;			
		}
	}

	@Override
	public String toString() {
		return "Intitulé: " + intitule + ", prix: " + prix;
	}
	
}