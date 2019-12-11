package tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tp.entity.Acteur;

@Repository
@Transactional //de Spring
public class ActeurDaoJpa implements ActeurDao {
	
	@PersistenceContext //pour demander une initialisation aux EJB ou a Spring
	private EntityManager entityManager;

	@Override
	public Acteur save(Acteur f) {
		if(f.getId()==null) {
		   entityManager.persist(f); //insert into et f.id est auto_incrementé
		}
		else {
		   entityManager.merge(f); //update sql
		  }
		return f;
	}
	
	@Override
	public Acteur findById(Long id) {
		return entityManager.find(Acteur.class, id);
	}

	@Override
	public void deleteById(Long id) {
		Acteur f =entityManager.find(Acteur.class, id);
		entityManager.remove(f);
	}

	@Override
	public List<Acteur> findAll() {
		//Session sessionHibernate = (Session) entityManager.getDelegate();
		//+ eventuelles instructions utilisant les spécificités de Session hibernate
		//pour les cas pointus seulement
		return entityManager.createNamedQuery("Acteur.findAll", Acteur.class)
				            .getResultList();
		
 	}

	

	

}
