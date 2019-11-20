package fr.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import fr.bean.Article;
import fr.bean.Catalogue;
import fr.bean.LigneCommande;
import fr.bean.Panier;

@Named
@SessionScoped
public class CatalogueBrowserBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int index;
	
	@Inject
	private Catalogue catalogue;
	
	private int nbArticles = 0;
	
	@Inject
	private Panier panier;
	
	public void affiche() {
		for (LigneCommande l : panier.getLigneCommandes()) {
			System.out.println(l);
		}
	}
	
	public void processPreviousAction(ActionEvent event) {
		if (index > 0) {
			index--;			
		}
	}
	
	public void processNextAction(ActionEvent event) {
		if (index < (catalogue.getSize() - 1)) {
			index++;
		}
	}
	
	public Article articleByIndex() {
		return catalogue.getArticles().get(index);
	}
	
	public void ajouterArticlePanier(Article article) {
		panier.ajouterArticle(article);
		int nb = 0;
		for (LigneCommande l : panier.getLigneCommandes()) {
			nb += l.getQuantite();
		}
		nbArticles = nb;
	}

	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Catalogue getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}

	public int getNbArticles() {
		return nbArticles;
	}

	public void setNbArticles(int nbArticles) {
		this.nbArticles = nbArticles;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

}
