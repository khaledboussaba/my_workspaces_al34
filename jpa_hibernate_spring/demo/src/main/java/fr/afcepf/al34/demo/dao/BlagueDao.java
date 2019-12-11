package fr.afcepf.al34.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.afcepf.al34.demo.entity.Blague;

public interface BlagueDao extends CrudRepository<Blague,Long>{
   /* principales méthodes héritées:
        Blague save(Blague b)
        Optional<Blague> findById(Long id)
        void deleteById(Long id)
        Iterable<Blague> findAll()
    */
	Blague findByTitre(String titre); //requete JpaQL généré automatiquement
									  //selon convention de nom de méthode
	List<Blague> findByGoodNote(); 
	//à coder via @NamedQuery(name="Blague.findByGoodNote") ou autre
	
	@Query("SELECT b FROM Blague b WHERE b.note < 3")
	List<Blague> findByBadNote();//codé via @Query 
	
}
