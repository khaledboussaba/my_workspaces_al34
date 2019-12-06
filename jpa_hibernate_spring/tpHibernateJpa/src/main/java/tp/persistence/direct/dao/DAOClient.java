package tp.persistence.direct.dao;

import java.util.List;

import tp.data.entity.Client;

public interface DAOClient {

	void removeClient(Client cli);

	Client ajouterClient(Client cli);

	Client modifierClient(Client cli);

	Client rechercherClientParNumero(long numero);

	List<Client> rechercherTousLesClients();

}