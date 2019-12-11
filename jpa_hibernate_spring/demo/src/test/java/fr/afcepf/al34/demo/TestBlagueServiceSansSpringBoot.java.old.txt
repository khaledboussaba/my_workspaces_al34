package fr.afcepf.al34.demo;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.afcepf.al34.demo.business.BlagueService;
import fr.afcepf.al34.demo.entity.Blague;
import fr.afcepf.al34.sansSpringBoot.app.config.AppConfig;

//Test unitaire ecrit avec Spring-test + Junit4
//et pourtant déclenché avec Junit5/jupiter via vintage 
// et run with / run configuration et choisir "Junit4" sous eclipse.
@RunWith(SpringJUnit4ClassRunner.class)
//ApplicationContext will be loaded from "/mySpringConf.xml" in the root of the classpath
//@ContextConfiguration(locations={"/mySpringConf.xml"})
@ContextConfiguration(classes={AppConfig.class})
public class TestBlagueServiceSansSpringBoot {
	
	@Autowired
	private BlagueService blagueService;
	
	@Test
	public void testBlague() {
		Blague b = blagueService.rechercherBlagueParId(1L);
		System.out.println(b.toString());
		Assert.assertNotNull(b);
	}

}
