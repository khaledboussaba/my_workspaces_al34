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
		Client client1 = clientService.sauvegarderClient(new Client("TOTO", "toto"));
		Client client2 = clientService.sauvegarderClient(new Client("TATA", "tata"));
		
		Compte cA = new Compte("Compte A", 100.11);
		cA.setClient(client1);
		compteService.sauvegarderCompte(cA);
		Compte cB = new Compte("Compte B", 200.22);
		cB.setClient(client1);
		compteService.sauvegarderCompte(cB);
		
		Compte cC = new Compte("Compte C", 300.33);
		cC.setClient(client2);
		compteService.sauvegarderCompte(cC);
		Compte cD = new Compte("Compte D", 400.44);
		cD.setClient(client2);
		compteService.sauvegarderCompte(cD);		
		
	}

}
