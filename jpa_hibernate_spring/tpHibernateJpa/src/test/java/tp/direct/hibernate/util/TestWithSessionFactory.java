package tp.direct.hibernate.util;

import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class TestWithSessionFactory {
	
	protected static SessionFactory sessionFactory;
	
	@BeforeClass
	public static void initSessionFactory(){
		sessionFactory = MyHibernateUtil.getSessionFactory();
	
	}
	
	@Before
	public void injectSessionFactory(){
		injectSessionFactoryInDao();
	}
	
	public abstract void injectSessionFactoryInDao();
	
	@AfterClass
	public static void closeSessionFactory(){
		sessionFactory.close();
	}

}
