package tp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.entity.Produit;



public class ProduitDaoJpa implements ProduitDao {
	
    private static Logger logger = LoggerFactory.getLogger(ProduitDaoJpa.class);
	
	
	private static EntityManagerFactory emf =null;
	
	//inner utility interface
	interface WithMyEntityManager<E>{
		public void callbackWithEntityManager(E obj,EntityManager em);
	}
	
	//E is @Entity type (ex: "Produit" or ...) 
	<E> void doWithTransaction(E obj, WithMyEntityManager<E> withEm){
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();
		try {
			withEm.callbackWithEntityManager(obj,em);
			em.getTransaction().commit();
		} catch (RuntimeException e) {
			em.getTransaction().rollback();
			logger.error("error with transation and entityManager :",e);
		}
		finally{
			em.close();
		}
	}
	
	
	
	
	public static EntityManagerFactory getEntityManagerFactory(){
		if(emf==null){
			//NB: myPersistenceUnit configuré dans META-INF/persistence.xml
		    emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		}
		return emf;
	}

	public void cleanUpResources(){
		logger.info("close entityManagerFactory");
		emf.close(); //idéalement entityManagerFactory.close(); en fin d'execution de l'application
	}
	
	
	private EntityManager getEntityManager()
	{
		EntityManager em = null;
		em=getEntityManagerFactory().createEntityManager();
		return em;
	}
	


	@Override
	public Produit createProduit(Produit nouveauProduit) {
		doWithTransaction(nouveauProduit,new WithMyEntityManager<Produit>(){
			@Override
			public void callbackWithEntityManager(Produit prod,EntityManager em) {
				em.persist(prod);//pk updated (auto_increment)				
			}
		});
		return nouveauProduit;
	}
	
	
	@Override
	public void deleteProduit(Produit produit) {
		doWithTransaction(produit,new WithMyEntityManager<Produit>(){
			@Override
			public void callbackWithEntityManager(Produit p,EntityManager em) {
				if(em.contains(p)){
				     em.remove(p); //persistent and ready to  be remvoved
				}else{
					Produit prod = em.find(Produit.class, p.getReference());
					em.remove(prod);
				}			
			}
		});
	}

	@Override
	public List<Produit> getAllProduits() {
		List<Produit> listeProd = new ArrayList<Produit>();
		EntityManager em = this.getEntityManager();
		try{
			listeProd = em.createQuery("SELECT p from Produit p",Produit.class).getResultList();
		} 
		finally{
			em.close();
		}
		return listeProd;
	}
	
	
	

	@Override
	public Produit getProduitByRef(long ref) {
		Produit prod=null;
		EntityManager em = this.getEntityManager();
		try {
			prod = em.find(Produit.class, ref);
		} 
		finally{
			em.close();
		}
		return prod;
	}

	@Override
	public void updateProduit(Produit p) {
		doWithTransaction(p,new WithMyEntityManager<Produit>(){
			@Override
			public void callbackWithEntityManager(Produit prod,EntityManager em) {
				em.merge(prod);			
			}
		});
	}

}
