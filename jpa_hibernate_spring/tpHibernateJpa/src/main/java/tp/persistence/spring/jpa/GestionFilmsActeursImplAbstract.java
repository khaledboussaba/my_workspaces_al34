package tp.persistence.spring.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import tp.data.entity.Acteur;
import tp.data.entity.Film;
import tp.persistence.spring.dao.GestionFilmsActeurs;

@Transactional
public abstract class GestionFilmsActeursImplAbstract implements GestionFilmsActeurs {
	
	@PersistenceContext
    protected EntityManager entityManager;
	/*
	//injection de dependance
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}*/

	public long createActeur(Acteur acteur) {
		entityManager.persist(acteur);
		return acteur.getIdActeur(); // return pk
	}

	public long createFilm(Film film) {
		entityManager.persist(film);
		return film.getIdFilm(); // return pk
	}

	
	public void deleteActeur(long idActeur) {
		Acteur acteur  = this.getActeurById(idActeur);
		entityManager.remove(acteur); 
	}
	
	public void updateActeur(Acteur acteur) {
		entityManager.merge(acteur); 
	}


	public void updateFilm(Film film) {
		entityManager.merge(film); 
	}

}
