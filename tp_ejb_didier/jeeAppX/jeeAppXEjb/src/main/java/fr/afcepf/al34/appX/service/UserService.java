package fr.afcepf.al34.appX.service;

import java.util.List;

import javax.ejb.Local;

import fr.afcepf.al34.appX.entity.User;

//@Remote si appel distant via RMI
//@Inject (coté web) foctionne avec @Local (coté EJB)
@Local //ejb accessible depuis la partie web prise en charge par le meme serveur jboss
public interface UserService {
	
	User createUser(User user);
	void modifyUser(User user);
	void removeUser(Long userId);
	User findUserById(Long userId);
	List<User> findAllUsers();
	// + autre méthodes ...
	// exemple grosTraitementRepartisSurPlusieursDao()
	
}
