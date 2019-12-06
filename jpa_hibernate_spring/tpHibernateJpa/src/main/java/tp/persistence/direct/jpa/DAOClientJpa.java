package tp.persistence.direct.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import tp.data.entity.Client;
import tp.data.entity.Devise;
import tp.persistence.direct.dao.DAOClient;
import tp.persistence.direct.dao.DAOJpa;

public class DAOClientJpa implements DAOClient , DAOJpa {
	
	private EntityManager entityManager;
	
	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	

	@Override
	public void removeClient(Client cli){
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(cli);
			entityManager.getTransaction().commit();
		} catch (RuntimeException e) {
			entityManager.getTransaction().rollback();
			System.err.println(e.getMessage());
		}
	}
	
	@Override
	public Client ajouterClient(Client cli){
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(cli);
			entityManager.getTransaction().commit();
		} catch (RuntimeException e) {
			entityManager.getTransaction().rollback();
			System.err.println(e.getMessage());
		}
		return cli;
	}
	
	
	@Override
	public Client modifierClient(Client cli){
		Client updatedCli = null;
		try {
			entityManager.getTransaction().begin();
			updatedCli = entityManager.merge(cli);
			entityManager.getTransaction().commit();
		} catch (RuntimeException e) {
			entityManager.getTransaction().rollback();
			System.err.println(e.getMessage());
		}
		return updatedCli;
	}
	
	@Override
	public Client rechercherClientParNumero(long numero){
		return entityManager.find(Client.class, numero);
	}
	

	@Override
	public List<Client> rechercherTousLesClients(){
		/*return  this.entityManager
				.createQuery("select c from Client c",Client.class)
				.getResultList();*/
		return  this.entityManager
				.createNamedQuery("client.findAll",Client.class)
				.getResultList();
	}
	
	

}
