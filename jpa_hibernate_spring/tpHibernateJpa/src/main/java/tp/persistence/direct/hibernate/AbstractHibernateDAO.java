package tp.persistence.direct.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tp.persistence.direct.dao.DAOHibernate;

public class AbstractHibernateDAO implements DAOHibernate{
	
	protected SessionFactory sessionFactory;

	@Override
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory=sf;
	}
	
	public Session currentSession(){
		//NB: <property name="hibernate.current_session_context_class">thread</property>
		//est necessaire dans hibernate.cfg.xml pour pouvoir appeler .getCurrentSession();
		//sinon exception "No CurrentSessionContext configured!"
		Session session = sessionFactory.getCurrentSession();//quelquefois recuperee dans thread
		//Session session = sessionFactory.openSession(); //toujours une nouvelle
		//bizarrement un appel à .getCurrentSession() plutot que .openSession()
		//impose d'encadrer .createQuery() par une transaction (même en lecture seule)
		return session;
	}

}
