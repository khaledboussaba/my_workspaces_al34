package fr.afcepf.al34.tp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al34.tp.dao.ClientDao;
import fr.afcepf.al34.tp.entity.Client;

@Service //heritant de @Component
@Transactional
public class ClientServiceImpl implements ClientService {
	
	@Autowired //ou @Inject
	private ClientDao clientDao;

	@Override
	public Client sauvegarderClient(Client client) {
		return clientDao.save(client);
	}

}
