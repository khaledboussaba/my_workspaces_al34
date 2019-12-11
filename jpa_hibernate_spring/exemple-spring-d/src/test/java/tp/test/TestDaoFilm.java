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
	
	@Autowired //equivalent spring de @Inject
	private /*interface*/FilmDao filmDao; //à tester
	
	@Autowired //equivalent spring de @Inject
	private /*interface*/ProducteurDao producteurDao; //à tester
	
	@Test
	public void test1() {
		Film fa = new Film(null,"titre_a",new Date());
		filmDao.save(fa);
		System.out.println("id du film sauvegardé:" + fa.getId());
		
		Producteur px = new Producteur(null,"nomProducteurX" , "prenomX");
		producteurDao.save(px);
		System.out.println("id du producteur sauvegardé:" + px.getId());
		Producteur py = new Producteur(null,"coProducteurY" , "prenomY");
		producteurDao.save(py);
		
		Film fb = new Film(null,"titre_b",new Date());
		/*	 px.addFilm(fb); ou bien px.getFilms().add(fb); suivi de producteurDao.save(px);
		 ne suffirait pas à enregistrer en base le lien entre fb et px;
		 car Producteur.films est préfixé par @...ToMany(mappedbBy="...") 
		 ET DONC COTE SECONDAIRE PAS BIEN ENREGISTRE/SAUVEGARDE		 */
		fb.addProducteur(px);
		fb.addProducteur(py);
		filmDao.save(fb); //ok 
		
		List<Film> listeFilms= filmDao.findAll();
		System.out.println("listeFilms="+listeFilms) ;
		Assert.assertTrue(listeFilms.size()>=2);
		
		//Film fbRelu = filmDao.findById(fb.getId());
		Film fbRelu = filmDao.findFilmByIdWithProductors(fb.getId());
		System.out.println("fbRelu="+fbRelu);
		
		for(Producteur prod : fbRelu.getProducteurs()) {
			//avec ou sans  LAZY exception
			System.out.println("producteur associe a fbRelu : " + prod.toString());
		}
	}

}
