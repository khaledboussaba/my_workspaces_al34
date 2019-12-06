package tp.dao;

import java.util.List;

import tp.entity.Film;


public interface FilmDao {
		public Film save(Film film); //create or update
		public List<Film> findAll();
		public Film findById(Long idFilm);
		public void deleteById(Long idFilm);
		
		public List<Film> findByTitre(String titre);
}
