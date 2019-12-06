
package tp.persistence.spring.jpa.test;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
//import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tp.data.entity.Devise;
import tp.persistence.spring.dao.DaoDevise;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/springContext.xml"})
public class TestDaoDeviseSpringJpa { 

    @Inject // de CDI ou bien @Autowired de Spring
	private DaoDevise daoDevise = null; // dao a tester
	
	
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
   public void test_getListeDevises() {
  
     try{
        System.out.println("test_getListeDevises");
       for(Devise d : daoDevise.getAllDevise()){
    	   System.out.println("\t"+d);
       }
        }catch(Exception /*RuntimeException*/ ex){
      	    System.err.println(ex.getMessage());
      	    Assert.fail(ex.getMessage());
      	}
   }
      
}
