package fr.afcepf.al34.o.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.afcepf.al34.o.dto.PropositionPret;
import fr.afcepf.al34.o.dto.ResCalculMensualite;
import fr.afcepf.al34.o.dto.ResFraisDossier;
import fr.afcepf.al34.o.dto.ResTauxInteretCourant;

@RestController
@RequestMapping(value="/pret-api/public/propositionPret" , headers="Accept=application/json")
public class PropositionPretRestCtrl {

	private String apiBanqueBaseUrl ="http://localhost:8686/api-banque";
	private String apiEmpruntBaseUrl ="http://localhost:8585/api-emprunt";

	//utilisation directe ou indirecte via BusinessDelagate
	private RestTemplate restTemplate = new RestTemplate();


	private Double recupererTauxInteretCourant(int nbMois){
		//http://localhost:8686/api-banque/tauxInteretCourant?nbMois=120
		String url= apiBanqueBaseUrl + "/tauxInteretCourant?nbMois=" + nbMois;
		System.out.println(url);
		ResTauxInteretCourant resTauxInteretCourant= restTemplate.getForObject(url, ResTauxInteretCourant.class);
		return resTauxInteretCourant.getTauxAnnuelPct();
	}

	private Double recupererFraisDossier(double  montant){
		//http://localhost:8686/api-banque/fraisDeDossier?montant=28900
		String url= apiBanqueBaseUrl + "/fraisDossier?montant="+montant;
		System.out.println(url);
		ResFraisDossier resFraisDossier= restTemplate.getForObject(url, ResFraisDossier.class);
		return resFraisDossier.getFraisDossier();
	}

	private Double recupererMensualite(double  montant,int nbMois,double tauxAnnuelPct){
		//http://localhost:8585/api-emprunt/mensualite?montant=2000&nbMois=120&tauxAnnuelPct=1
		String url= apiEmpruntBaseUrl+"/mensualite?montant="+montant
				+"&nbMois="+nbMois+"&tauxAnnuelPct="+tauxAnnuelPct;
		System.out.println(url);
		ResCalculMensualite resCalculMensualite= restTemplate.getForObject(url, ResCalculMensualite.class);
		return resCalculMensualite.getMensualite();
	}

	@GetMapping("")
	public PropositionPret getPropositionPret(
			@RequestParam(value="montant",required=true) double montant,
			@RequestParam(value="nbMois",required=true) int nbMois) {
		
		//orchestration de services:
		double tauxInteretAnnuelPct = this.recupererTauxInteretCourant(nbMois);//donnée pivot
		double mensualite = this.recupererMensualite(montant, nbMois, 
				/*donnée pivot*/tauxInteretAnnuelPct);
		//+quelfois if(promo) , frais de dossier offert
		double fraisDossier= this.recupererFraisDossier(montant);

		//construction et retour de la proposition de pret :
		PropositionPret propositionPret = new PropositionPret();
		propositionPret.setMontant(montant);
		propositionPret.setNbMois(nbMois);
		propositionPret.setTauxInteretAnnuelPct(tauxInteretAnnuelPct);
		propositionPret.setMensualite(mensualite);
		propositionPret.setFraisDossier(fraisDossier);
		return propositionPret;
	}

}
