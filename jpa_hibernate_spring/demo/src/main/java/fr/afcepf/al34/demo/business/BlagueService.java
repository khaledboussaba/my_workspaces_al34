package fr.afcepf.al34.demo.business;

import fr.afcepf.al34.demo.entity.Blague;

public interface BlagueService {
	Blague rechercherBlagueParId(Long id);
	Blague sauvegarderBlague(Blague b);
	void transfererNote(int nbPoints,Long idb1,Long idb2);
	//CAS d'ecole (ressemblant à un virement bancaire).
	//nouvelle note de b1 = ancienne note de b1 - nbPoints
	//nouvelle note de b2 = ancienne note de b2 + nbPoints
}
