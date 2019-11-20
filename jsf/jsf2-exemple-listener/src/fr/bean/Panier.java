package fr.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class Panier implements Serializable {
	private static final long serialVersionUID = 1L;
	
	List<LigneCommande> ligneCommandes = new ArrayList<LigneCommande>();
	
	

	public Panier() {
	}
		
	public Panier(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

	public void ajouterArticle(Article article) {
		System.out.println("Ajout");
		boolean doublant = false;
		
		for (LigneCommande l : ligneCommandes) {
			System.out.println("CONDITION");
			if (l.getArticle().getNom().equals(article.getNom())) {
				l.ajouterQuantite();
				doublant = true;
			} 
		}
		
		if (! doublant) {
			System.out.println("NOUVEAU");
			LigneCommande x = new LigneCommande(article, 1);
			ligneCommandes.add(x);
		}
		
	}
	
	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}
	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}
	
	public void afficher() {
		
	}
}
