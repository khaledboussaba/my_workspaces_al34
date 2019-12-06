package tp.persistence.service;

import tp.data.entity.Compte;

public interface ServiceCompte {
	
	void virement(double montant,long numCptDeb,long numCptCred);
	Compte rechercherCompte(long num);

}
