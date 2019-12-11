package fr.afcepf.al34.demo.init;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import fr.afcepf.al34.demo.business.BlagueService;
import fr.afcepf.al34.demo.entity.Blague;

@Profile("initData") //code ci-dessus activé que si le profile "initData" est choisi (parmis d'autres)
                     //au démarrage d'un test ou de l'application
@Component
public class InitDataSet {
	
	@Autowired
	BlagueService blagueService;
	
	
	@PostConstruct
	public void initJeuxDeDonneesQueJaime() {
		blagueService.sauvegarderBlague(new Blague(null,"blague que la chaise", "elle est pliante"));
		for(int i = 0; i<10;i++) {
			blagueService.sauvegarderBlague(new Blague(null,"blague"+i, "texte de blague" + i));
		}
	}

}
