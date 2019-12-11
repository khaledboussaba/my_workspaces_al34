package fr.afcepf.al34.tp.service;

import java.util.List;

import fr.afcepf.al34.tp.entity.Client;

public interface ClientService {
	List<Client> rechercherTousLesClient();
	Client sauvegarderCompte(Client client);
}
