package tp.dao;

import java.util.List;

import tp.entity.Producteur;

/*
 * DAO = Data Access Object 
 * avec méthodes CRUD (Create, Retreive/Recherche , Update , Delete)
 */

public interface ProducteurDao {
		public Producteur save(Producteur p); //create or update
		public List<Producteur> findAll();
		public Producteur findById(Long id);
		//public Optional<Producteur> findById(Long id);
		public void deleteById(Long id);
		
}
