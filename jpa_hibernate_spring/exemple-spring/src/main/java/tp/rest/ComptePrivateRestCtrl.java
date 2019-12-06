package tp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tp.entity.Compte;
import tp.service.ServiceCompte;

// on appelle "api rest" un paquet de web services REST concernant un même domaine fonctionnel
// ex: api-compte , api-facture

// il y a souvent , une partie "public" accessible à tous (GET, pas confidentiel)
//                  une partie "private" accessible qu'après authentification

//---> URL completes conseillées
//  .../rest/api-compte/public/compte/1 (en GET)
//  .../rest/api-compte/private/compte/1 (en DELETE)

@CrossOrigin("*")//pour accepter de répondre à des appels ajax 
//provenant d'autres domaines/applications/...

//controleur REST pour les comptes bancaires
@RestController
@RequestMapping(value="/rest/api-compte/private/compte" , headers="Accept=application/json")
public class ComptePrivateRestCtrl {
	
	@Autowired //injection du service métier pour déléguer traitements
	private ServiceCompte serviceCompte;
	

	//http://localhost:8080/myMvcSpringBootApp/rest/api-compte/private/compte
	//invoqué en mode POST avec { "label" : "compte Xy" , "solde" : 50.0 } 
	// (Content-Type:application/json)
	//appelable qu'en retransmettant le "Bearer token" 
	//dans le champ "Authorization" de l'entete HTTP
 	@RequestMapping(value="" , method=RequestMethod.POST)
    public  Compte postCompte(@RequestBody Compte compte){
		serviceCompte.sauvegarderCompte(compte);
		return compte;//on retourne l'objet ajouté avec la clef primaire
		              //auto incrémentée
	}

}
