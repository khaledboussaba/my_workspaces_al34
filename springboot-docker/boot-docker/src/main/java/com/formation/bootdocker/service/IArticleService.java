package com.formation.bootdocker.service;

import java.util.List;

import com.formation.bootdocker.entity.Article;

public interface IArticleService {
	
	List<Article> getAllArticles();
	Article getArticleById(Long articleId);
	boolean addArticle(Article article);
	void updateArticle(Article article);
	void deleteArticle(Long articleId);
	boolean articleExists(String title, String category);

}
