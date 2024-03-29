package tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tp.entity.Film;
import tp.entity.Producteur;

@Repository
@Transactional
public class FilmDaoJpa implements FilmDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Film save(Film film) {
		if(film.getIdFilm() == null) {
			em.persist(film);			
		}
		else {
			em.merge(film);			
		}
		return film;
	}

	@Override
	public Film findById(Long idFilm) {
		return em.find(Film.class, idFilm);
	}

	@Override
	public void deleteById(Long idFilm) {
		Film f = em.find(Film.class, idFilm);
		em.remove(f);
	}

	@Override
	public List<Film> findAll() {
		return em.createNamedQuery("Film.findAll", Film.class).getResultList();
	}

	@Override
	public List<Film> findByTitre(String titre) {
		return em.createNamedQuery("Film.findByTitre", Film.class).setParameter("titreQueJeRecherche", titre).getResultList();
	}

	public Film findFilmByIdWithProducteurV1(Long idFilm) {
		Film f = findById(idFilm);
		/*
		for (Producteur p : f.getProducteurs()) {
			//TODO : boucle for pour remonter les éléments du collection Lazy
		}
		*/
		f.getProducteurs().size(); // boucle for interne pour connaitre la taille (solution au LAZY)
		return f;
	}
	
	@Override
	public Film findFilmByIdWithProducteur(Long idFilm) {
		String jpaQuery = "SELECT f FROM Film f INNER JOIN fetch f.producteurs p WHERE f.id =:id";
		return em.createQuery(jpaQuery, Film.class).setParameter("id", idFilm).getSingleResult();
	}

}
