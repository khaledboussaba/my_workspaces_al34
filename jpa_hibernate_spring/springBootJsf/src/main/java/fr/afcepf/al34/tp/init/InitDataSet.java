package fr.afcepf.al34.tp.init;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import fr.afcepf.al34.tp.entity.Client;
import fr.afcepf.al34.tp.entity.Compte;
import fr.afcepf.al34.tp.service.ClientService;
import fr.afcepf.al34.tp.service.CompteService;

@Profile("initData") //code ci-dessus activé que si le profile "initData" est choisi (parmis d'autres) au démarrage d'un test ou de l'application
@Component
public class InitDataSet {
	
	@Autowired
	CompteService compteService;
	
	@Autowired
	ClientService clientService;
	
	
	@PostConstruct
	public void initJeuxDeDonneesQueJaime() {
		compteService.sauvegarderCompte(new Compte("Compte A", 100.11));
		compteService.sauvegarderCompte(new Compte("Compte B", 200.22));
		compteService.sauvegarderCompte(new Compte("Compte C", 300.33));
		compteService.sauvegarderCompte(new Compte("Compte D", 400.44));
		
		clientService.sauvegarderCompte(new Client("TOTO", "toto"));
		clientService.sauvegarderCompte(new Client("TATA", "tata"));
		clientService.sauvegarderCompte(new Client("TITI", "titi"));
		clientService.sauvegarderCompte(new Client("TUTU", "tutu"));
	}

}
