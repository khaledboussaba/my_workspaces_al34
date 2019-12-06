package tp.persistence.direct.jpa.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import tp.data.entity.Client;
import tp.data.entity.Devise;
import tp.data.entity.Pays;
import tp.direct.jpa.util.TestWithEntityManager;
import tp.persistence.direct.dao.DAOClient;
import tp.persistence.direct.dao.DAOJpa;
import tp.persistence.direct.jpa.DAOClientJpa;

public class TestDAOClientWithEntityManager extends TestWithEntityManager {
	
	private DAOClient daoClient ; // dao a tester
	
	@Override //indirectly called by @Before inherited method
	protected void injectEntityManagerIntoService() {
		daoClient = new DAOClientJpa();
		((DAOJpa)daoClient).setEntityManager(this.entityManager);
	}
	
	@Test
	   public void test_updateClient() {
	     try{
	        System.out.println("test_updateClient");
	        Client c = daoClient.rechercherClientParNumero(1L);
	        c.setPrenom(c.getPrenom()+"*");
	        Client updatedCli = daoClient.modifierClient(c);
	        System.out.println("client (apres *) : " + updatedCli);
	        }catch(Exception /*RuntimeException*/ ex){
	      	    System.err.println(ex.getMessage());
	      	    Assert.fail(ex.getMessage());
	      	}
	   }
		
	@Test
	   public void test_rechercherClientParNumero() {
	     try{
	        System.out.println("rechercherClientParNumero");
	        Client c = daoClient.rechercherClientParNumero(1L);
	        System.out.println("client 1: " + c);
	        Assert.assertTrue(c.getNumero()==1L);
	        }catch(Exception /*RuntimeException*/ ex){
	      	    System.err.println(ex.getMessage());
	      	    Assert.fail(ex.getMessage());
	      	}
	   }
	
	@Test
	   public void test_getListeClient() {
	     try{
	        System.out.println("test_getListeClient");
	        List<Client> listeClient = daoClient.rechercherTousLesClients();
	        Assert.assertTrue(listeClient.size()>=2);
	        for(Client c : listeClient){
	            System.out.println("\t" + c);
	            Assert.assertTrue(c != null);
	        }
	        }catch(Exception /*RuntimeException*/ ex){
	      	    System.err.println(ex.getMessage());
	      	    Assert.fail(ex.getMessage());
	      	}
	   }


	

}
