package tp.persistence.direct.hibernate.test;

import org.junit.Assert;
import org.junit.Test;

import tp.data.entity.Devise;
import tp.direct.hibernate.util.TestWithSessionFactory;
import tp.persistence.direct.dao.DAODevise;
import tp.persistence.direct.dao.DAOHibernate;
import tp.persistence.direct.hibernate.DAODeviseHibernate;

public class TestDAODeviseWithSessionFactory extends TestWithSessionFactory {

	private DAODevise daoDevise;
	
	@Override
	public void injectSessionFactoryInDao() {
		System.out.println("sessionFactory = " + TestWithSessionFactory.sessionFactory);
		daoDevise = new DAODeviseHibernate();
		((DAOHibernate) daoDevise).setSessionFactory(TestWithSessionFactory.sessionFactory);		
	}
	
	@Test
	   public void test_getDeviseByName() {
	     try{
	        System.out.println("test_getDeviseByName");
	        Devise d = daoDevise.getDeviseByName("euro");
	        System.out.println("monnaie euro (getDeviseByName) : " + d);
	        Assert.assertTrue(d.getMonnaie().equals("euro"));
	        }catch(Exception /*RuntimeException*/ ex){
	      	    System.err.println(ex.getMessage());
	      	    Assert.fail(ex.getMessage());
	      	}
	   }
	
	@Test
	   public void test_updateDevise() {
	     try{
	        System.out.println("test_updateDevise");
	        Devise d = daoDevise.getDeviseByName("euro");
	        d.setChange(d.getChange()*1.05);
	        Devise updatedDev = daoDevise.updateDevise(d);
	        System.out.println("monnaie euro (apres * 1.05) : " + updatedDev);
	        Assert.assertTrue(d.getMonnaie().equals("euro"));
	        }catch(Exception /*RuntimeException*/ ex){
	      	    System.err.println(ex.getMessage());
	      	    Assert.fail(ex.getMessage());
	      	}
	   }

}
