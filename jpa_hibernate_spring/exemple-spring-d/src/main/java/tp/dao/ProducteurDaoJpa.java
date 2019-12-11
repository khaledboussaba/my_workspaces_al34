package tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tp.entity.Producteur;

@Repository
@Transactional //de Spring
public class ProducteurDaoJpa implements ProducteurDao {
	
	@PersistenceContext //pour demander une initialisation aux EJB ou a Spring
	private EntityManager entityManager;

	@Override
	public Producteur save(Producteur p) {
		if(p.getId()==null) {
			   entityManager.persist(p); //insert into et p.id est auto_incrementé
			}
			else {
			   entityManager.merge(p); //update sql
			  }
			return p;
	}

	@Override
	public List<Producteur> findAll() {
		return entityManager.createNamedQuery("Producteur.findAll", Producteur.class)
	            .getResultList();
	}

	@Override
	public Producteur findById(Long id) {
		return entityManager.find(Producteur.class, id);
	}

	@Override
	public void deleteById(Long id) {
		Producteur p =entityManager.find(Producteur.class, id);
		entityManager.remove(p);

	}

}
