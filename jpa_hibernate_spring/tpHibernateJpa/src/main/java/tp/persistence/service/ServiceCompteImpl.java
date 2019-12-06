package tp.persistence.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import tp.data.entity.Compte;
import tp.persistence.spring.dao.DaoCompte;

@Named //ou @Stateless
@Transactional
public class ServiceCompteImpl implements ServiceCompte {
	
	@Inject  //ou @EJB
	private DaoCompte daoCompte;

	@Override
	public void virement(double montant, long numCptDeb, long numCptCred)
	{
		//spring ou EJB cree/initialise "entityManager" et "transaction"
		//dès le debut de l'execution d'une méthode
		Compte cptDeb= daoCompte.getEntityById(numCptDeb);
		Compte cptCred= daoCompte.getEntityById(numCptCred);
        cptDeb.setSolde(cptDeb.getSolde()-montant);
        cptCred.setSolde(cptCred.getSolde()+montant);
        //pas besoin d'appeler daoCompte.updateEntity(cptDeb)
        //qui declenche le merge car cptDeb est a l'etat PERSISTANT
        //dans une méthode transactionnelle spring ou EJB
        
      //spring ou EJB ferme "entityManager" et "transaction"
      //en fin de l'execution d'une méthode
      //.commit() appel .flush() qui fait l'équivalent de .merge()
	}

	@Override
	public Compte rechercherCompte(long num) {
		return daoCompte.getEntityById(num);
	}

}
