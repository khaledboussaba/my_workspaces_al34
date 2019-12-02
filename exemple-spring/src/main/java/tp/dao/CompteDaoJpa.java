package tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tp.entity.Compte;

//CompteDaoJpa: version codée via JPA
//Java Persistence Api (et Hibernate)

@Repository
@Transactional()//version spring
public class CompteDaoJpa implements CompteDao {
	
	@PersistenceContext //pour initialiser entityManager avec
	//META-INF/persistence.xml ou bien application.properties
	private EntityManager entityManager;

	@Override
	public Compte save(Compte cpt) {
		if(cpt.getNumero()==null) {
			entityManager.persist(cpt); //INSERT INTO SQL automatique
		}else {
			entityManager.merge(cpt); //UPDATE SQL automatique
		}
		return null;
	}

	@Override
	public List<Compte> findAll() {
		return entityManager.createQuery("SELECT c FROM Compte c", Compte.class)
				.getResultList();
	}

	@Override
	public Compte findById(Long num) {
		return entityManager.find(Compte.class, num);
		//SELECT ... WHERE numero=?
	}

	@Override
	public void deleteById(Long num) {
		Compte cpt = entityManager.find(Compte.class, num);
		entityManager.remove(cpt);//DELETE SQL
	}

	@Override
	public List<Compte> findByClientNumero(long numClient) {
		//requete exprimée en JPAQL = SQL adaptée à java (nom classe et nom de propriété)
		return entityManager.createQuery("SELECT c FROM Compte c WHERE c.client.numero=?1", Compte.class)
				.setParameter(1, numClient)
				.getResultList();
	}

}
