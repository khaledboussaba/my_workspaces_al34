package tp.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import tp.entity.Client;
import tp.entity.Compte;
import tp.service.ServiceCompte;

//classe utilitaire pour réinitialiser un jeux de données (en mode developpement)

@Profile("dev") //sera pris en compte seulement si 
// app.setAdditionalProfiles("h2","dev"); dans le main() en mode dev
@Component
public class ReInitDataSet {
	@Autowired
	private ServiceCompte serviceCompte;
	
	@PostConstruct
	public void initDataSet() {
		Client cliA = new Client(null,"Bon", "Jean");
		serviceCompte.sauvegarderClient(cliA);
		
		Compte cA = new Compte(null,"compteA",50.0);
		cA.setClient(cliA); serviceCompte.sauvegarderCompte(cA);
		Compte cB = new Compte(null,"compteB",150.0);
		cB.setClient(cliA); serviceCompte.sauvegarderCompte(cB);
		Compte cC = new Compte(null,"compteC",250.0);
		serviceCompte.sauvegarderCompte(cC);
		
	}

}
