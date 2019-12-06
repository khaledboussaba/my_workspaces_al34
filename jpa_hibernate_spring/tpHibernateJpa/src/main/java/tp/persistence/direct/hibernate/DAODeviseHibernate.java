package tp.persistence.direct.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tp.data.entity.Devise;
import tp.data.entity.Pays;
import tp.persistence.direct.dao.DAODevise;

public class DAODeviseHibernate extends AbstractHibernateDAO implements DAODevise {
		

	@Override
	public void deleteDevise(String codeDevise) {
		Session session = this.currentSession();
		Transaction tx = session.beginTransaction();
		try {
			Devise dev = (Devise) this.currentSession().get(Devise.class, codeDevise);
			if(dev!=null)
			   session.delete(dev);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.err.println(e.getMessage());
			throw e;
		}
	}

	@Override
	public void removeDevise(Devise dev) {
		Session session = this.currentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(dev);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.err.println(e.getMessage());
			throw e;
		}
	}

	@Override
	public Devise updateDevise(Devise dev) {
		Session session = this.currentSession();
		Transaction tx = session.beginTransaction();
		try {
			//session.update(dev); ou bien session.saveOrUpdate(dev); ou bien 
			dev=(Devise)session.merge(dev);
			tx.commit();
			return dev;
		} catch (Exception e) {
			tx.rollback();
			System.err.println(e.getMessage());
			throw e;
		}
	}

	@Override
	public Devise getDeviseByCode(String codeDevise) {
		return  (Devise) this.currentSession().get(Devise.class, codeDevise);
	}

	@Override
	public Devise persistNewDevise(Devise dev) {
		Session session = this.currentSession();
		Transaction tx = session.beginTransaction();
		try {
			Object pk = session.save(dev); 
			//session.persist(dev);
			tx.commit();
			return dev;
		} catch (Exception e) {
			tx.rollback();
			System.err.println(e.getMessage());
			throw e;
		}
	}

	@Override
	public Devise getDeviseByName(String deviseName) {
		Transaction tx = currentSession().beginTransaction();
		Devise d =  (Devise) this.currentSession()
				.createQuery("select d from Devise d where d.monnaie = :deviseName")
				.setParameter("deviseName",deviseName)
				.uniqueResult();
		tx.commit();
		return d;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Devise> getAllDevise() {
		return  (List<Devise>) this.currentSession()
				.createQuery("select d from Devise d")
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pays> getListePaysPartageantDevise(String codeDevise) {
		return  (List<Pays>) this.currentSession()
				.createQuery("select p from Pays p inner join p.devise d where d.codeDevise = :codeDevise")
				.setParameter("codeDevise",codeDevise)
				.list();

	}

	

}
