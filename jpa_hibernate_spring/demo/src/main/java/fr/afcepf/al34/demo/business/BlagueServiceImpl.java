package fr.afcepf.al34.demo.business;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al34.demo.dao.BlagueDao;
import fr.afcepf.al34.demo.entity.Blague;
import lombok.Setter;

@Setter
//@Component
@Service //id par defaut = blagueServiceImpl
@Transactional
public class BlagueServiceImpl implements BlagueService {
	
	@Autowired //demander à injecter/référencer un composant Spring
	           //compatible avec l'interface BlagueDao
	private BlagueDao blagueDao; //avec setter obligatoire pour config xml/java

	public BlagueServiceImpl() {
		System.out.println("dans le constructeur de BlagueServiceImpl , blagueDao="+blagueDao);
	}
	
	@PostConstruct
	public void initAfterAllInjections() {
		System.out.println("dans méthode préfixée par @PostConstruct, blagueDao="+blagueDao);
	}
	
	
	@Override
	public Blague rechercherBlagueParId(Long id) {
		//return blagueDao.findById(id).get();//renvoie exception si rien trouvé (si null interne dans optional)
		return blagueDao.findById(id).orElse(null); //renvoie null si Optional contient null
		//return blagueDao.findById(id).orElse(new Blague(null,"blague nulle" , "pour les nuls")); 
	}

	@Override
	public Blague sauvegarderBlague(Blague b) {
		return blagueDao.save(b);
	}

	@Override
	//@Transactional(propagation = Propagation.REQUIRED) //par défaut avec Spring et EJB
	//@Transactional()
	public void transfererNote(int nbPoints, Long idb1, Long idb2) {
	    try {
			Blague b1 = blagueDao.findById(idb1).get();
			b1.setNote(b1.getNote()-nbPoints);
			if(b1.getNote()<0) throw new RuntimeException("note inférieure à zero invalide");
			//blagueDao.save(b1); //indispensable seulement si pas de @Transactional
			
			Blague b2 = blagueDao.findById(idb2).get();
			b2.setNote(b2.getNote()+nbPoints);
			if(b2.getNote()>5) throw new RuntimeException("note supérieure à 5 invalide");
			//blagueDao.save(b2); //indispensable seulement si pas de @Transactional
		} catch (Exception e) {
			//logger.error(...);
			throw new RuntimeException("echec transfererNote",e);
		}
	}

}
