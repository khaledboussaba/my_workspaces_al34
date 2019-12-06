package tp.dao;

import java.util.List;

import tp.entity.Acteur;


public interface ActeurDao {
		public Acteur save(Acteur acteur); //create or update
		public List<Acteur> findAll();
		public Acteur findById(Long idActeur);
		public void deleteById(Long idActeur);
}
