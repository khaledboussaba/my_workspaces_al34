package fr.afcepf.al34.tp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al34.tp.dao.CompteDao;
import fr.afcepf.al34.tp.entity.Compte;

@Service //heritant de @Component
@Transactional
public class CompteServiceImpl implements CompteService {

	@Autowired // ou @Inject
	private CompteDao compteDao;
	
	@Override
	public List<Compte> rechercherTousLesComptes() {
		return (List<Compte>) compteDao.findAll();
	}

	@Override
	public Compte sauvegarderCompte(Compte compte) {
		return compteDao.save(compte);
	}

}
