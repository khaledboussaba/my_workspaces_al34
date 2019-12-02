package tp.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tp.entity.Compte;
import tp.service.ServiceCompte;

//test unitaire (JUnit)

//Solutions des Tps sur https://github.com/didier-tp/nova-spring

public class TestServiceCompteV1 {
	private ServiceCompte serviceCompte; //à tester
	
	@Before
	public void initTest() {
		ApplicationContext contextSpring =
				new ClassPathXmlApplicationContext("springContext.xml");
		this.serviceCompte = (ServiceCompte)contextSpring.getBean("serviceCompteImpl"/*id*/);
		//this.serviceCompte = contextSpring.getBean(ServiceCompte.class);
		//+.close() ideal dans méthode préfixée par @After ou @AfterClass
	}
	
	@Test
	public void testRechercherCompteParNumero() {
		Compte c1 = serviceCompte.rechercherCompteParNumero(1L);
		System.out.println(c1.getLabel());
		Assert.assertTrue(c1.getNumero()==1L);
	}
}
