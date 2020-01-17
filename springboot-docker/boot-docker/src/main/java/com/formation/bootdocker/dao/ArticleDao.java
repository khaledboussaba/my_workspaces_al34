package com.formation.bootdocker.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.bootdocker.entity.Article;

@Transactional
@Repository
public class ArticleDao implements IArticleDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAllArticles() {
		String hql = "FROM Article as atcl ORDER BY atcl.articleId";
		return (List<Article>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Article getArticleById(Long articleId) {
		return entityManager.find(Article.class, articleId);
	}

	@Override
	public void addArticle(Article article) {
		entityManager.persist(article);
	}

	@Override
	public void updateArticle(Article article) {
		Article updatedArticle = getArticleById(article.getArticleId());
		updatedArticle.setTitle(article.getTitle());
		updatedArticle.setCategory(article.getCategory());
		entityManager.flush();
	}

	@Override
	public void deleteArticle(Long articleId) {
		entityManager.remove(getArticleById(articleId));
	}

	@Override
	public boolean articleExists(String title, String category) {
		String hql = "FROM Article as atcl WHERE atcl.title = ? AND atcl.category = ?";
		int count = entityManager.createQuery(hql).setParameter(1, title).setParameter(2, category).getResultList().size();
		return count > 0 ? true : false;
	}

}
