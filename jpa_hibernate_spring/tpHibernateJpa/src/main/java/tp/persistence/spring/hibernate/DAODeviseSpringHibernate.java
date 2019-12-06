package tp.persistence.spring.hibernate;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import tp.data.entity.Devise;
import tp.data.entity.Pays;
import tp.persistence.direct.dao.DAODevise;

@Named //ou @Component
@Transactional
public class DAODeviseSpringHibernate implements DAODevise {
	
	@Inject //ou @Autowired
	private SessionFactory sessionFactory;
	
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void deleteDevise(String codeDevise) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeDevise(Devise dev) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Devise updateDevise(Devise dev) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Devise getDeviseByCode(String codeDevise) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Devise persistNewDevise(Devise dev) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Devise getDeviseByName(String deviseName) {
		return  (Devise) this.currentSession()
				.createQuery("select d from Devise d where d.monnaie = :deviseName")
				.setParameter("deviseName",deviseName)
				.uniqueResult();
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
