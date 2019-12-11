package fr.afcepf.al34.tp.service;

import java.util.List;

import fr.afcepf.al34.tp.entity.Compte;

public interface CompteService {
	List<Compte> rechercherTousLesComptes();
	Compte sauvegarderCompte(Compte compte);
}
