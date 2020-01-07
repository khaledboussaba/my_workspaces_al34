package fr.afcepf.al34.ws.cli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import fr.afcepf.al34.ws.cli.dto.DeviseDto;
import fr.afcepf.al34.ws.cli.service.DeviseServiceDelegate;

@SpringBootApplication
public class MySpringBootApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(MySpringBootApplication.class);
		ConfigurableApplicationContext context = app.run(args);
		System.out.println("http://localhost:8282/cliRestSpring");
		
		testAppelWsRest();
		
	}
	
	private static void testAppelWsRest() {
		DeviseServiceDelegate deviseServiceDelegate = new DeviseServiceDelegate();
		DeviseDto deviseEur = deviseServiceDelegate.getDeviseByCode("EUR");
		System.out.println("deviseEur = " + deviseEur);
	}
	
}
