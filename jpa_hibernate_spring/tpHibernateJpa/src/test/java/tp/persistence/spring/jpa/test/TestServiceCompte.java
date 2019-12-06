
package tp.persistence.spring.jpa.test;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
//import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tp.data.entity.Compte;
import tp.data.entity.Operation;
import tp.persistence.service.ServiceCompte;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/springContext.xml"})
public class TestServiceCompte { 

    @Inject
	private ServiceCompte serviceCompte = null; //  a tester
	
    @Test
    public void test_virement(){
    	double s1 = serviceCompte.rechercherCompte(1L).getSolde();
    	double s2 = serviceCompte.rechercherCompte(2L).getSolde();
    	System.out.println("avant s1="+s1 + " et s2=" + s2);
    	serviceCompte.virement(50, 1L, 2L);
    	s1 = serviceCompte.rechercherCompte(1L).getSolde();
    	s2 = serviceCompte.rechercherCompte(2L).getSolde();
    	System.out.println("apres s1="+s1 + " et s2=" + s2);
    }
	
      
}
