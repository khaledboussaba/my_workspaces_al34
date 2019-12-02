package tp.test;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import tp.MySpringBootApplication;
import tp.aop.code.Calculateur;
import tp.aop.code.CalculateurEx;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MySpringBootApplication.class})
@ActiveProfiles("h2")
public class TestAop {

	@Autowired
	private Calculateur calculateur;
	
	@Autowired
	private CalculateurEx calculateurExterne;
	
	@Test
	public void testCalculateur() {
		double res = calculateur.addition(34, 8);
		System.out.println("resultat = " + res);
		Assert.assertEquals(42, res, 0.00001);
	}
	
	@Test
	public void testCalculateurExterne() {
		double res = calculateurExterne.carre(9);
		System.out.println("resultat = " + res);
		Assert.assertEquals(81, res, 0.00001);
		//assertTrue(res == 81);
	}
	
}
