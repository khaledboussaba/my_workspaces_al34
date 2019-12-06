package tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tp.entity.Producteur;

@Repository
@Transactional
public class ProducteurDaoJpa implements ProducteurDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Producteur save(Producteur producteur) {
		if(producteur.getIdProducteur() == null)
			em.persist(producteur);
		else 
			em.merge(producteur);
		return producteur;
	}

	@Override
	public List<Producteur> findAll() {
		return em.createNamedQuery("Producteur.findAll", Producteur.class).getResultList();
	}

	@Override
	public Producteur findById(Long idProducteur) {
		return em.find(Producteur.class, idProducteur);
	}

	@Override
	public void deleteById(Long idProducteur) {
		Producteur p = em.find(Producteur.class, idProducteur);
		em.remove(p);
	}

}
