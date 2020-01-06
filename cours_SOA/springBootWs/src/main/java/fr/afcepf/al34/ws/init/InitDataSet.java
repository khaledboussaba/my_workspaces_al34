package fr.afcepf.al34.ws.init;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import fr.afcepf.al34.ws.entity.Devise;
import fr.afcepf.al34.ws.service.DeviseService;

@Profile("initData") //en développement seulement, pas en production
@Component
public class InitDataSet {

	@Autowired
	private DeviseService deviseService;
	
	@PostConstruct
	public void init() {
		deviseService.sauvegarderDevise(new Devise("EUR", "euro", 0.9));
		deviseService.sauvegarderDevise(new Devise("USD", "dollar", 1.0));
		deviseService.sauvegarderDevise(new Devise("GBP", "livre", 0.8));
		deviseService.sauvegarderDevise(new Devise("JPY", "yen", 120.0));
	}
	
}
