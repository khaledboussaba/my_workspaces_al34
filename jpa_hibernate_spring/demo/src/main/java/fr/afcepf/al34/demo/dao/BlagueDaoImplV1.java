package fr.afcepf.al34.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al34.demo.entity.Blague;


//DAO Générique :
// sans Spring-data : https://github.com/didier-mycontrib/jee-spring-app-demo/blob/master/minibank2015/minibank2015-services/src/main/java/org/mycontrib/generic/persistence/AbstractGenericDaoJpaImpl.java
// avec String-data

//@Component
@Repository //id par defaut = blagueDaoImpl
@Transactional
public class BlagueDaoImplV1 implements BlagueDaoV1 {
	
	//@Autowired
	//private DataSource dataSource; //utile pour dao codé avec JDBC
	
	@PersistenceContext
	private EntityManager entityManager;
	//entityManager créé par EntityManagerFactory utilisant dataSource en interne

	@Override
	public Blague findById(Long id) {
		// v1 : simulation sans base de données
		//String texte="texte de la blague " + dataSource.toString() ;
		//return new Blague(id ,"blague_" + id , texte);
		//v2 (jpa):
		return entityManager.find(Blague.class,id);
	}

	@Override
	public Blague save(Blague b) {
		if(b.getId()==null) {
			entityManager.persist(b);
		}else {
			entityManager.merge(b);
		}
		return b;
	}

}
