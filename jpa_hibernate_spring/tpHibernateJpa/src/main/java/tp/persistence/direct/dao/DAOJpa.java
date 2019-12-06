package tp.persistence.direct.dao;

import javax.persistence.EntityManager;

public interface DAOJpa {
	    //injection de "entityManager" créé via factory
		public void setEntityManager(EntityManager entityManager);
}
