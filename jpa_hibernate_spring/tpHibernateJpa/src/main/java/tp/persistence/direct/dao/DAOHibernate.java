package tp.persistence.direct.dao;

import org.hibernate.SessionFactory;

public interface DAOHibernate {
	//injection du "SessionFactory" hibernate
	public void setSessionFactory(SessionFactory sf);

}
