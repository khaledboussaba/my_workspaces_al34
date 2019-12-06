
package tp.persistence.spring.jpa.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
//import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tp.data.entity.Compte;
import tp.data.entity.Operation;
import tp.persistence.spring.dao.DaoCompte;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/springContext.xml"})
public class TestDaoCompteSpringJpa { 

    @Inject
	private DaoCompte daoCompte = null; // dao a tester
    
    @Test
    public void test_comptesDuClient(){
    	List<Compte> listeComptes = daoCompte.getComptesDuClient(1L);
    	Assert.assertTrue(listeComptes.size()>=2);
    	System.out.println("liste des comptes du client 1:");
    	for(Compte c : listeComptes)
    		System.out.println("\t"+c);
    }
	
    @Test
    public void test_compteAvecOperations(){
    	//Compte c = daoCompte.getEntityById(1L); //avec "lazy exception"
    	
    	Compte c = daoCompte.getCompteAvecOperations(1L);
    	//nouvelle méthode sur interface tp.persistence.spring.dao.DaoCompte
    	// et sur classe tp.persistence.spring.jpa.DaoCompteSpringJpa
    	System.out.println("compte_1 : "+c);
    	for(Operation op : c.getOperations()){
    		System.out.println("\t"+op);
    	}
    	Assert.assertTrue(c.getOperations().size()>0);
    }
	
	@Test
   public void test_getListeComptes() {
  
     try{
        System.out.println("test_getListeComptes");
       for(Compte c : daoCompte.getAllCompte()){
    	   System.out.println("\t"+c);
       }
        }catch(Exception /*RuntimeException*/ ex){
      	    System.err.println(ex.getMessage());
      	    Assert.fail(ex.getMessage());
      	}
   }
	
	@Test
	   public void test_addNewCompte() {
	  
	     try{
	        System.out.println("test_addNewCompte");
	         Compte c = new Compte(null,"nouveauCompte",100.0);
	         Compte savedCompte = daoCompte.persistNewEntity(c);
	         System.out.println("added:" + savedCompte);
	        }catch(Exception /*RuntimeException*/ ex){
	      	    System.err.println(ex.getMessage());
	      	    Assert.fail(ex.getMessage());
	      	}
	   }
      
}
