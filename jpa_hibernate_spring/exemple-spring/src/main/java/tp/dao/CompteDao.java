package tp.dao;

import java.util.List;

import tp.entity.Compte;

/*
 * DAO = Data Access Object 
 * avec méthodes CRUD (Create, Retreive/Recherche , Update , Delete)
 */

public interface CompteDao {
		public Compte save(Compte cpt); //create or update
		public List<Compte> findAll();
		public Compte findById(Long num);
		//public Optional<Compte> findById(Long num);
		public void deleteById(Long num);
		
		public List<Compte> findByClientNumero(long numClient);
}
