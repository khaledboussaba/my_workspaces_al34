package tp.data.entity;

import java.util.Date;

public class Film {
	private long idFilm;
	private String titre;
	private Date date;
	private String producteur;
	
	public long getIdFilm() {
		return idFilm;
	}
	public void setIdFilm(long idFilm) {
		this.idFilm = idFilm;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String nom) {
		this.titre = nom;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getProducteur() {
		return producteur;
	}
	public void setProducteur(String producteur) {
		this.producteur = producteur;
	}
	@Override
	public String toString() {
		return "[" + idFilm+ "] " + this.getTitre() + " - "+ this.getProducteur();
	}
	
	
	
}
