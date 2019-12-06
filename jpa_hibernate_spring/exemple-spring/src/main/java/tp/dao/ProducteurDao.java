package tp.dao;

import java.util.List;

import tp.entity.Producteur;


public interface ProducteurDao {
		public Producteur save(Producteur producteur); //create or update
		public List<Producteur> findAll();
		public Producteur findById(Long idProducteur);
		public void deleteById(Long idProducteur);
}
