package tp.dao;

import java.util.List;

import tp.entity.Acteur;

/*
 * DAO = Data Access Object 
 * avec méthodes CRUD (Create, Retreive/Recherche , Update , Delete)
 */

public interface ActeurDao {
		public Acteur save(Acteur f); //create or update
		public List<Acteur> findAll();
		public Acteur findById(Long id);
		//public Optional<Acteur> findById(Long id);
		public void deleteById(Long id);
		
}
