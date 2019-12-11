package fr.afcepf.al34.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import fr.afcepf.al34.demo.business.BlagueService;
import fr.afcepf.al34.demo.entity.Blague;

//NB: @SpringBootApplication est un équivalent
//de @Configuration + @EnableAutoConfiguration + @ComponentScan/current package

@SpringBootApplication
//NB: tres important : Toutes les classes (de @Configuration ou bien @Service , @Component)
//qui doivent être prises en compte par Spring boot doivent être dans des sous packages de demo
//tout ce qui est à coté de démo doit être explicitement importé par @Import ou équivalent
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(MySpringBootApplication.class, args);
		SpringApplication app = new SpringApplication(DemoApplication.class);
		//on peut depuis un .bat ou .sh qui lance l'application java SpringBoot
		// java .... -Dspring.profiles.active="initData" 
		app.setAdditionalProfiles("initData","profile2ComplementaireQueJaimeEtQuiExistePasEncore");
		ConfigurableApplicationContext contextSpring = app.run(args);
		
		//Blague b1 = new Blague(null,"blague1", "blague pas drole");
		BlagueService s = contextSpring.getBean(BlagueService.class);
		//s.sauvegarderBlague(b1);
		Blague b = s.rechercherBlagueParId(/*b1.getId()*/ 1L );
		System.out.println(b.toString());
		//+close() idealement
	}

}
//la partie @EnableAutoConfiguration de @SpringBootApplication fait que le fichier
//application.properties sera automatiquement analysé
