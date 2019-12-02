package tp.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tp.dao.ClientDao;
import tp.dao.CompteDao;
import tp.entity.Client;
import tp.entity.Compte;

@Service //hérite de @Component
@Transactional(/* propagation = Propagation.REQUIRED par defaut */)
public class ServiceCompteImpl implements ServiceCompte {
	
	@Autowired //sur le private ou bien sur le setCompteDao(...)
	//via @Autowired , on demande au framework spring d'initialiser la variable compteDao
	//en référençant un composant spring existant compatible avec l'interface CompteDao.
	private CompteDao compteDao; //pour référencer le dao en arrière plan
	
	@Autowired
	//NB: l'instance injectée (compatible avec l'interface ClientDao)
	//sera d'une classe automatiquement générée par Spring-Data (en version jpa)
	private ClientDao clientDao;
	
	@Override
	public void sauvegarderClient(Client cli) {
		clientDao.save(cli);
	}
	
	public ServiceCompteImpl() {
		System.out.println("dans constructeur,compteDao= " + compteDao);
	}
	
	@PostConstruct
	public void initAfterInjections() {
		System.out.println("dans méthode préfixée par @PostConstruct,compteDao= " + compteDao);
	}
	
	//setter jouant ici le rôle de fonction 
	//d'injection de dépendance
	public void setCompteDao(CompteDao compteDao) {
		this.compteDao = compteDao;
	}

	@Override
	public Compte rechercherCompteParNumero(Long num) {
		return compteDao.findById(num);//au délègue au dao
	}

	@Override
	//@Transactional() ici ou sur la classe entière 
	public void transferer(double montant, long numCptDeb, long numCptCred) {
		try {
			Compte cptDeb = compteDao.findById(numCptDeb);
			cptDeb.setSolde(cptDeb.getSolde()-montant);
			compteDao.save(cptDeb);
			
			Compte cptCred = compteDao.findById(numCptCred);
			cptCred.setSolde(cptCred.getSolde()+montant);
			compteDao.save(cptCred);
		} catch (Exception e) {
			//+eventuel ajout d'une ligne de log via logger
			throw new RuntimeException("echec transfert",e);
			//throw new MyServiceException("echec transfert",e); //héritant de RuntimeException
		}
	}

	@Override
	public void sauvegarderCompte(Compte c) {
		compteDao.save(c);
	}

	@Override
	public List<Compte> recupererComptesDuClient(long numClient) {
		return compteDao.findByClientNumero(numClient);
	}

	

}
