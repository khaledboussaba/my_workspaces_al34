package tp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping(value="/rest/api-compte/public/compte" , headers="Accept=application/json")
public class CompteRestCtrl {
	
	@Autowired //injection du service métier pour déléguer traitements
	private ServiceCompte serviceCompte;
	
	//http://localhost:8080/myMvcSpringBootApp/rest/api-compte/public/compte?numCli=1
	@RequestMapping(value="" , method=RequestMethod.GET)
	public List<Compte> getComptesByCriteria(@RequestParam(value="numCli",required=false) 
	                                          Long numClient){
		if(numClient==null) {
			return  null;
			//return serviceCompte.rechercherTousLesComptes(); //à coder et à appeler
		}
		else {	return serviceCompte.recupererComptesDuClient(numClient);
		}	
	}
	//http://localhost:8080/myMvcSpringBootApp/rest/api-compte/public/compte/1
	@RequestMapping(value="/{numCompte}" , method=RequestMethod.GET)
    public  Compte getCompteByNum(@PathVariable("numCompte") Long num){
		return serviceCompte.rechercherCompteParNumero(num);
	}

}
