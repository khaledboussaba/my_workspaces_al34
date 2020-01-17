package com.formation.bootdocker.dao;

import java.util.List;

import com.formation.bootdocker.entity.Article;

public interface IArticleDao {

	List<Article> getAllArticles();
	Article getArticleById(Long articleId);
	void addArticle(Article article);
	void updateArticle(Article article);
	void deleteArticle(Long articleId);
	boolean articleExists(String title, String category);
	
}
