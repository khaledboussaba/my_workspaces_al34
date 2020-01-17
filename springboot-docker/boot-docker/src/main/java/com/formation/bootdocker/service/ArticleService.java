package com.formation.bootdocker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.bootdocker.dao.IArticleDao;
import com.formation.bootdocker.entity.Article;

@Service
public class ArticleService implements IArticleService {

	@Autowired
	private IArticleDao articleDao;
	
	@Override
	public List<Article> getAllArticles() {
		return articleDao.getAllArticles();
	}

	@Override
	public Article getArticleById(Long articleId) {
		Article article = articleDao.getArticleById(articleId);
		return article;
	}

	@Override
	public boolean addArticle(Article article) {
		if (articleDao.articleExists(article.getTitle(), article.getCategory())) {
			return false;
		} else {
			return false;
		}
	}

	@Override
	public void updateArticle(Article article) {
		articleDao.updateArticle(article);
	}

	@Override
	public void deleteArticle(Long articleId) {
		articleDao.deleteArticle(articleId);
	}

	@Override
	public boolean articleExists(String title, String category) {
		return articleDao.articleExists(title, category);
	}

}
