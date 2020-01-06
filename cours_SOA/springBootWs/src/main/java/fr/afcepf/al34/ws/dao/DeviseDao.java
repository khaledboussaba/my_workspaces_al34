package fr.afcepf.al34.ws.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.afcepf.al34.ws.entity.Devise;

public interface DeviseDao extends CrudRepository<Devise, String> {
	// principales méthodes héritées
	// Devise save (Devise d)
	// Optionnal<Devise> findById(String codeDevise)
	// void deleteById(String codeDevise)
	
	//selon la convention de noms de méthodes (pour génération automatique du sql)
	List<Devise> findByName(String name);
	List<Devise> findByChangeGreaterThanEqual(Double changeMini); // >= changeMini
	List<Devise> findByChangeLessThanEqual(Double changeMaxi); // <= changeMaxi

}
