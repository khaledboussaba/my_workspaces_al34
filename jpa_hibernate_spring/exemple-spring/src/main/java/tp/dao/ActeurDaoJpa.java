package tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tp.entity.Acteur;

public class ActeurDaoJpa implements ActeurDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Acteur save(Acteur acteur) {
		if (acteur.getIdActeur() == null) {
			em.persist(acteur);
		} else {
			em.persist(acteur);
		}
		return acteur;
	}

	@Override
	public List<Acteur> findAll() {
		return em.createNamedQuery("Acteur.findAll", Acteur.class).getResultList();
	}

	@Override
	public Acteur findById(Long idActeur) {
		return em.find(Acteur.class, idActeur);
	}

	@Override
	public void deleteById(Long idActeur) {
		Acteur a = em.find(Acteur.class, idActeur);
		em.remove(a);
	}

}
