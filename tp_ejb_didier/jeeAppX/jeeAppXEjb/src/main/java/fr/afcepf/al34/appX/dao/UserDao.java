package fr.afcepf.al34.appX.dao;

import java.util.List;

import javax.ejb.Local;

import fr.afcepf.al34.appX.entity.User;

@Local
public interface UserDao {

	User insertUser(User user);
	void updateUser(User user);
	void deleteUser(Long userId);
	User getUserById(Long userId);
	List<User> getAllUsers();
	
}
