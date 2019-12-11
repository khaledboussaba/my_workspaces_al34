package fr.afcepf.al34.tp.dao;

import org.springframework.data.repository.CrudRepository;

import fr.afcepf.al34.tp.entity.Client;

public interface ClientDao extends CrudRepository<Client,Long>{
   //principales méthodes héritées : findById() , save() , deleteById() , ...

}
