package fr.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class Catalogue implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Article> articles = new ArrayList<Article>();	

	public Catalogue() {
		articles.add(new Article(1, "Ordinateur", 299.00, "PC portable"));
		articles.add(new Article(2, "Téléphone", 499.00, "NOKIA 3310"));
		articles.add(new Article(3, "Imprimante", 99.00, "EPSON 235"));
		articles.add(new Article(4, "Téléviseur", 150.00, "Télé 4k"));
		articles.add(new Article(5, "Clavier", 39.00, "Clavier ordinateur"));
	}
	
	public int getSize() {
		return articles.size();
	}
	
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
}
