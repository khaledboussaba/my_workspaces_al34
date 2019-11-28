package fr.afcepf.al34.appX.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.al34.appX.entity.User;

//EJB session sans état
// @Stateless //Ejb3 et EJB 3.1, 3.2
@Singleton //variante de @Stateless depuis EJB 3.1
public class UserDaoImpl implements UserDao {

	@PersistenceContext // pour initialiser le EntityManager en fonction de META-INF/persistence.xml
	EntityManager em;
	
	@Override
	public User insertUser(User user) {
		em.persist(user); // insert dans la BDD
		return user;
	}

	@Override
	public void updateUser(User user) {
		/*
		try {
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();			
		} catch (RuntimeException e) {
			em.getTransaction().rollback();
		}
		*/		
		em.merge(user);
	}

	@Override
	public void deleteUser(Long userId) {
		User user = getUserById(userId);
		em.remove(user);
	}

	@Override
	public User getUserById(Long userId) {
		return em.find(User.class, userId);
	}

	@Override
	public List<User> getAllUsers() {
		return em.createQuery("SELECT u FROM User u", User.class).getResultList();
	}

}
