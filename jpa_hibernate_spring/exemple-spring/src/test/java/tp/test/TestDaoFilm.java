package tp.test;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import tp.MySpringBootApplication;
import tp.dao.FilmDao;
import tp.dao.ProducteurDao;
import tp.entity.Film;
import tp.entity.Producteur;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {MySpringBootApplication.class})
@ActiveProfiles("h2")
public class TestDaoFilm {

	@Autowired
	private FilmDao filmDao;
	
	@Autowired
	private ProducteurDao producteurDao;
	
	@Test
	public void test1() {
		Film filmA = new Film("titre_A", new Date());
		filmDao.save(filmA);
		System.out.println("id du premier film sauvegardé : " + filmA.getIdFilm());
				
		Producteur producteur1 = new Producteur("nomProducteur1", "prenomProducteur1");
		producteurDao.save(producteur1);
		System.out.println("id du producteur sauvegardé : " + producteur1.getIdProducteur());
		
		Producteur producteur2 = new Producteur("nomProducteur2", "prenomProducteur2");
		producteurDao.save(producteur2);
		
		Film filmB = new Film("titre_B", new Date());
		filmB.addProducteur(producteur1);
		filmB.addProducteur(producteur2);
		filmDao.save(filmB);
		System.out.println("id du Deuxieme film sauvegardé : " + filmB.getIdFilm());
		
		List<Film> films = filmDao.findAll();
		System.out.println("Liste des films : " + films);
		
		Assert.assertTrue(films.size() >= 2);
		
		//Film filmBRelu = filmDao.findById(filmB.getIdFilm());
		Film filmBRelu = filmDao.findFilmByIdWithProducteur(filmB.getIdFilm());
		System.out.println("filBRelu = " + filmBRelu);
		
		for (Producteur pr : filmBRelu.getProducteurs()) {
			//A priori Lazy Exception
			System.out.println("Producteur associés à filmBRelu = " + pr.toString());
		}
		
	}
	
}
