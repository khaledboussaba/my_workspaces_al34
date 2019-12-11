package tp.dao;

import org.springframework.data.repository.CrudRepository;

import tp.entity.Client;

public interface ClientDao extends CrudRepository<Client, Long>{
  /*principales méthodes héritées:
	public Client save(Client cpt); //create or update
	public List<Client> findAll();
	Optional<Client> findById(Long num);
	public void deleteById(Long num);
	 */
	//+eventuelles methodes spécifiques au client
}
