package fr.afcepf.al34.appX.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import fr.afcepf.al34.appX.dao.UserDao;
import fr.afcepf.al34.appX.entity.User;

//@Stateless
@Singleton
/*
@TransactionManagement(TransactionManagementType.CONTAINER) -> c'est par défaut
trasaction géré automatiquement par le conteneur d'EJB (partie de JBoss) 
 */
/*
@TransactionAttribute(TransactionAttributeType.REQUIRED) -> c'est par défaut
REQUIRED signifie besoin de .beginTransaction() et .commit() / .rollback 
*/
public class UserServiceImpl implements UserService {

	//@Inject // depuis EJB 3.1 nécessite META-INF/beans.xml
	@EJB // depuis EJB 3.0
	private UserDao dao;
	
	@Override
	public User createUser(User user) {
		return dao.insertUser(user);
	}

	@Override
	public void modifyUser(User user) {
		dao.updateUser(user);
	}

	@Override
	public void removeUser(Long userId) {
		dao.deleteUser(userId);
	}

	@Override
	public User findUserById(Long userId) {
		return dao.getUserById(userId);
	}

	@Override
	public List<User> findAllUsers() {
		return dao.getAllUsers();
	}

}
