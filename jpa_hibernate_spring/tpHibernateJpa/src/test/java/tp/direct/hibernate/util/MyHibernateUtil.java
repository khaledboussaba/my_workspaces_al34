package tp.direct.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MyHibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory(){
		if(sessionFactory == null){
			//.configure() sans parametre recherche par defaut hibernate.cfg.xml 
			//à la racine du classpath (src/main/resources ou ...)
			sessionFactory = new Configuration()
					.configure("hibernateSansJpa/hibernate.cfg.xml")
					.buildSessionFactory();
		}
		return sessionFactory;
	}

}
