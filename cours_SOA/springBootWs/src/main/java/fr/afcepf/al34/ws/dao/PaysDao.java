package fr.afcepf.al34.ws.dao;

import org.springframework.data.repository.CrudRepository;

import fr.afcepf.al34.ws.entity.Pays;

public interface PaysDao extends CrudRepository<Pays, String> {

}
