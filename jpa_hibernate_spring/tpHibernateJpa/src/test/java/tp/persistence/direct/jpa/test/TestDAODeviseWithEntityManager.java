package tp.persistence.direct.jpa.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import tp.data.entity.Devise;
import tp.data.entity.Pays;
import tp.direct.jpa.util.TestWithEntityManager;
import tp.persistence.direct.dao.DAODevise;
import tp.persistence.direct.dao.DAOJpa;
import tp.persistence.direct.jpa.DAODeviseJpa;

public class TestDAODeviseWithEntityManager extends TestWithEntityManager {
	
	private DAODevise daoDevise ; // dao a tester
	
	@Test
	   public void test_updateDevise() {
	     try{
	        System.out.println("test_updateDevise");
	        Devise d = daoDevise.getDeviseByName("euro");
	        
	        double ancienChange = d.getChange();
	        
	        d.setChange(d.getChange()*1.05);
	        Devise updatedDev = daoDevise.updateDevise(d);
	        System.out.println("monnaie euro (apres * 1.05) : " + updatedDev);
	        Assert.assertTrue(d.getMonnaie().equals("euro"));
	        
	        this.entityManager.clear();//car ici test sans spring
	        
	        Devise d_apres_relecture = daoDevise.getDeviseByName("euro");
	        Assert.assertEquals(ancienChange * 1.05, d_apres_relecture.getChange(), 0.001);
	        
	        }catch(Exception /*RuntimeException*/ ex){
	      	    System.err.println(ex.getMessage());
	      	    Assert.fail(ex.getMessage());
	      	}
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
	   public void test_getListePaysPartageantDevise() {
	     try{
	        System.out.println("test_getListePaysPartageantDevise");
	        List<Pays> listePays = daoDevise.getListePaysPartageantDevise("EUR");
	        Assert.assertTrue(listePays.size()>2);
	        for(Pays p : listePays){
	            System.out.println("\t" + p);
	            Assert.assertTrue(p.getDevise().getMonnaie().equals("euro"));
	        }
	        }catch(Exception /*RuntimeException*/ ex){
	      	    System.err.println(ex.getMessage());
	      	    Assert.fail(ex.getMessage());
	      	}
	   }


	@Override //indirectly called by @Before inherited method
	protected void injectEntityManagerIntoService() {
		daoDevise = new DAODeviseJpa();
		((DAOJpa)daoDevise).setEntityManager(this.entityManager);
	}

}
