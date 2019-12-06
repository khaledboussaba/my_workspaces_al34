package tp.persistence.direct.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import tp.data.entity.Devise;
import tp.data.entity.Pays;
import tp.persistence.direct.dao.DAODevise;
import tp.persistence.direct.dao.DAOJpa;

public class DAODeviseJpa implements DAODevise , DAOJpa{
	
	protected EntityManager entityManager;
	
	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager=entityManager;
	}

	@Override
	public void deleteDevise(String codeDevise) {
		try {
			entityManager.getTransaction().begin();
			Devise dev = entityManager.find(Devise.class,codeDevise);
			if(dev!=null)
				entityManager.remove(dev);
			entityManager.getTransaction().commit();
		} catch (RuntimeException e) {
			entityManager.getTransaction().rollback();
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void removeDevise(Devise dev) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(dev);
			entityManager.getTransaction().commit();
		} catch (RuntimeException e) {
			entityManager.getTransaction().rollback();
			System.err.println(e.getMessage());
		}
	}

	@Override
	public Devise updateDevise(Devise dev) {
		Devise updatedDev = null;
		try {
			entityManager.getTransaction().begin();
			updatedDev = entityManager.merge(dev);
			entityManager.getTransaction().commit();
		} catch (RuntimeException e) {
			entityManager.getTransaction().rollback();
			System.err.println(e.getMessage());
		}
		return updatedDev;
	}

	@Override
	public Devise getDeviseByCode(String codeDevise) {
		return entityManager.find(Devise.class,codeDevise);
	}

	@Override
	public Devise persistNewDevise(Devise dev) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(dev);
			entityManager.getTransaction().commit();
		} catch (RuntimeException e) {
			entityManager.getTransaction().rollback();
			System.err.println(e.getMessage());
		}
		return dev;
	}

	@Override
	public Devise getDeviseByName(String deviseName) {
		/*
		Session session= (Session) entityManager.getDelegate();
		
		return  (Devise)session
				.createQuery("select d from Devise d where d.monnaie = :deviseName")
				.setParameter("deviseName",deviseName)
				.uniqueResult();
		*/
		
		return  this.entityManager
				.createQuery("select d from Devise d where d.monnaie = :deviseName",Devise.class)
				.setParameter("deviseName",deviseName)
				.getSingleResult();
				
	}

	@Override
	public List<Devise> getAllDevise() {
		return  this.entityManager
				.createQuery("select d from Devise d",Devise.class)
				.getResultList();
	}

	@Override
	public List<Pays> getListePaysPartageantDevise(String codeDevise) {
		return  this.entityManager
				.createQuery("select p from Pays p inner join p.devise d where d.codeDevise = :codeDevise",Pays.class)
				.setParameter("codeDevise",codeDevise)
				.getResultList();

	}

	

}
