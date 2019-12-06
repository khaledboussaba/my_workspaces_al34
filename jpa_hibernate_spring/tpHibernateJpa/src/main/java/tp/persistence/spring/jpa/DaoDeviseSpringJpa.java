
package tp.persistence.spring.jpa;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.mycontrib.generic.persistence.GenericDaoJpaImpl;
import org.springframework.transaction.annotation.Transactional;

import tp.data.entity.Devise;
import tp.persistence.spring.dao.DaoDevise;

@Named // de CDI ou @Component de Spring , pour la classe java
// soit prise ne charge par Spring (un peu @Stateless des EJB)
@Transactional //pour que spring declenche automatiquement des 
//commit , rollback
public class DaoDeviseSpringJpa extends GenericDaoJpaImpl<Devise,String> implements DaoDevise {

	/*
	@PersistenceContext()
	private EntityManager entityManager;
	*/
	
	@Override
	public Devise getDeviseByName(String deviseName) {
		return  this.entityManager
				.createQuery("select d from Devise d where d.monnaie = :deviseName",Devise.class)
				.setParameter("deviseName",deviseName)
				.getSingleResult();
	}
	    //public List<_Devise> findDeviseByXyz(...){ .... }

	
	@Override
	public List<Devise> getAllDevise() {
		return  this.entityManager
				.createQuery("select d from Devise d",Devise.class).getResultList();
	}
}
