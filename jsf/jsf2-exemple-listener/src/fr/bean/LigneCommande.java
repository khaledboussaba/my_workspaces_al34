package fr.bean;

public class LigneCommande {
	
	private Article article;
	private int quantite;	
	
	public LigneCommande() {
	}

	public LigneCommande(Article article, int quantite) {
		this.article = article;
		this.quantite = quantite;
	}

	public void ajouterQuantite() {
		quantite++;
	}
	
	public void dimibuerQuantite() {
		quantite--;
	}
	
	@Override
	public String toString() {
		return "Article : " + article.getNom() + "------ Quantité : " + quantite;
	}

	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}
