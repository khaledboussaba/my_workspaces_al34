package tp.test;

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
@SpringBootTest(classes= {MySpringBootApplication.class})
@ActiveProfiles("h2")
public class TestAop {
		
	@Autowired
	private Calculateur calculateur;
	
	@Autowired
	private CalculateurEx calculateurEx;
	
	@Test
	public void testCalculateur() {
		double res =calculateur.addition(5, 6);
		System.out.println("res add="+res);
		Assert.assertEquals(11, res,0.00001);
	}
	
	@Test
	public void testCalculateurEx() {
		double res =calculateurEx.carre(9);
		System.out.println("res carre="+res);
		Assert.assertEquals(81, res,0.00001);
	}
}
