package tp.dao;

import java.util.List;

import tp.entity.Film;

/*
 * DAO = Data Access Object 
 * avec méthodes CRUD (Create, Retreive/Recherche , Update , Delete)
 */

public interface FilmDao {
		public Film save(Film f); //create or update
		public List<Film> findAll();
		public Film findById(Long id);
		//public Optional<Film> findById(Long id);
		public void deleteById(Long id);
		
		public List<Film> findByTitre(String titre);
		
		public Film findFilmByIdWithProductors(Long id);
}
