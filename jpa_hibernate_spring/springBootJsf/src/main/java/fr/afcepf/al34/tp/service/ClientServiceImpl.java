package fr.afcepf.al34.tp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al34.tp.dao.ClientDao;
import fr.afcepf.al34.tp.entity.Client;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDao clientDao;
	
	@Override
	public List<Client> rechercherTousLesClient() {
		return (List<Client>) clientDao.findAll();
	}

	@Override
	public Client sauvegarderCompte(Client client) {
		return clientDao.save(client);
	}

}
