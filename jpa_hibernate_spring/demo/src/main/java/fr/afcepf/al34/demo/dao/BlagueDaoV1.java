package fr.afcepf.al34.demo.dao;

import fr.afcepf.al34.demo.entity.Blague;

public interface BlagueDaoV1 {
	Blague  findById(Long id);
	Blague save(Blague b);//insert or update
}
