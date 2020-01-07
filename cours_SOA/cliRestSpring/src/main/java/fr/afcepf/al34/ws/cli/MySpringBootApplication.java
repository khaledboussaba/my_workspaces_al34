package fr.afcepf.al34.ws.cli;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import fr.afcepf.al34.ws.cli.dto.DeviseDto;
import fr.afcepf.al34.ws.cli.service.DeviseServiceDelegate;
import fr.afcepf.al34.ws.cli.service.IDeviseService;

@SpringBootApplication
public class MySpringBootApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(MySpringBootApplication.class);
		ConfigurableApplicationContext context = app.run(args);
		System.out.println("http://localhost:8282/cliRestSpring");
		
		testAppelWsRest(context);
		
	}
	
	/* 
	 * variante 1 avec DeviseServiceDelegate sans @Service (pas vu comme composant spring)
	private static void testAppelWsRest() {
		
		DeviseServiceDelegate deviseServiceDelegate = new DeviseServiceDelegate();
		DeviseDto deviseEur = deviseServiceDelegate.getDeviseByCode("EUR");
		System.out.println("deviseEur = " + deviseEur);
		
	}
	*/
	// variante 2 avec DeviseServiceDelegate comportant @Service (vu comme composant spring)
	private static void testAppelWsRest(ApplicationContext contextSpring) {
		IDeviseService deviseServiceDelegate = contextSpring.getBean(IDeviseService.class);
		DeviseDto deviseEur = deviseServiceDelegate.getDeviseByCode("EUR");
		System.out.println("deviseEur = " + deviseEur);
		
		DeviseDto nouvelleDevise = new DeviseDto("sc", "Super Credit", 0.02);
		DeviseDto deviseSauvegardee = deviseServiceDelegate.postDevise(nouvelleDevise);
		System.out.println("deviseSauvegardee = " + deviseSauvegardee);
		
		List<DeviseDto> listDevises = deviseServiceDelegate.getAllDevises();
		System.out.println("listDevises = " +listDevises);
		
		deviseServiceDelegate.deleteDevise("sc");
		//verif suppression
		DeviseDto deviseScSuprimee = deviseServiceDelegate.getDeviseByCode("sc");
		System.out.println("deviseSuprimee = " + deviseScSuprimee);
	}
	
}
