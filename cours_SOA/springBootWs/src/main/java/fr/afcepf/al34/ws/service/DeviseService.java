package fr.afcepf.al34.ws.service;

import java.util.List;

import fr.afcepf.al34.ws.entity.Devise;
import fr.afcepf.al34.ws.exception.MyEntityNotFoundException;

public interface DeviseService {
	
	Devise rechercherDeviseParSonCode(String code);
	List<Devise> rechercherDeviseParChangeMini(Double change);
	
	Devise sauvegarderDevise(Devise devise);
	void supprimerDevise(String code) throws MyEntityNotFoundException;

	List<Devise> rechercherToutesDevises();
	//...
	
}
