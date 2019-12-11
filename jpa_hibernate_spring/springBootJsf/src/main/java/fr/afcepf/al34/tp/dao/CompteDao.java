package fr.afcepf.al34.tp.dao;

import org.springframework.data.repository.CrudRepository;

import fr.afcepf.al34.tp.entity.Compte;

public interface CompteDao extends CrudRepository<Compte, Long> {
	//principales méthodes héritées : findById(), save(), deleteById(), ...
	
}