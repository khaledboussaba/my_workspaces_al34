package tp.persistence.spring.jpa.test;


import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tp.data.entity.ActeurV1;
import tp.data.entity.FilmV1;
import tp.persistence.spring.dao.GestionFilmsActeurs;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/springContext.xml"})
public class TestActeurFilmV1Jpa {
	
	@Inject
	@Qualifier("v1")//version Spring (pas CDI)
	private GestionFilmsActeurs serviceGestionFilmsActeurs = null; 
    
    @Test
	public void testFilmsOfActeur(){
		System.out.println("***** testFilmsOfActeur *****");
		ActeurV1 a = (ActeurV1) serviceGestionFilmsActeurs.getActeurWithFilmsById(1);
		System.out.println("Acteur " + a.toString());
		for(FilmV1 f : a.getFilms())
			System.out.println("\t" + f);
	}
	
    @Test
	public void testActeursOfFilm(){
		System.out.println("***** testActeursOfFilm *****");
		FilmV1 f = (FilmV1) serviceGestionFilmsActeurs.getFilmWithActorsById(1);
		System.out.println("film " + f.toString());
		for(ActeurV1 a : f.getActeurs())
			System.out.println("\t" + a);
	}
	
    @Test
	public void testNouveauFilmPourActeurV1() {
		FilmV1 f = null;
		ActeurV1 a1 = null , a2=null;
			System.out.println("****** testNouveauFilmPourActeurV1 (n-n JPA) *****");
			
			// sequence habituelle : new , save , getAll , maj , update , get , delete 
			
			FilmV1 nouveauFilm = new FilmV1();
			nouveauFilm.setTitre("nom du nouveau film");
			nouveauFilm.setDate(new java.util.Date());
			nouveauFilm.setProducteur("nouveau producteur");
			
			serviceGestionFilmsActeurs.createFilm(nouveauFilm);
			long num_film = nouveauFilm.getIdFilm();
			System.out.println("id du nouveau film: " + num_film);
			
			a1 = (ActeurV1) serviceGestionFilmsActeurs.getActeurById(1);
			a2 = (ActeurV1) serviceGestionFilmsActeurs.getActeurById(2);
			
			serviceGestionFilmsActeurs.attachActorToFilm(nouveauFilm, a1);
			serviceGestionFilmsActeurs.attachActorToFilm(nouveauFilm, a2);
			
			System.out.println("liste des films de l'acteur 1 (apres insertion/sauvegarde nouveau film):");
			a1 = (ActeurV1) serviceGestionFilmsActeurs.getActeurWithFilmsById(1);
			for(FilmV1 fx : a1.getFilms())
				System.out.println("\t" + fx);
			
			
			System.out.println("=== nouveau film (avec acteurs) relu en base =====");
			f = (FilmV1) serviceGestionFilmsActeurs.getFilmWithActorsById(num_film);
			System.out.println(f);
			Assert.assertTrue(f.getIdFilm()==num_film);
			Assert.assertTrue(f.getTitre().equals("nom du nouveau film"));
			for(ActeurV1 ax : f.getActeurs())
				System.out.println("\t" + ax);
			
			
			// mise a jour:
			f.setTitre("film_xy");
			serviceGestionFilmsActeurs.updateFilm(f);
			
			// verif:
			f=(FilmV1) serviceGestionFilmsActeurs.getFilmById(num_film);
			Assert.assertTrue(f.getTitre().equals("film_xy"));
			System.out.println("apres mise a jour " + f.toString());
			
			System.out.println("liste des films de l'acteur 1 (apres mise a jour du film):");
			a1 = (ActeurV1)serviceGestionFilmsActeurs.getActeurWithFilmsById(1);
			for(FilmV1 fy : a1.getFilms())
				System.out.println("\t" + fy);
			
			// suppression film:
			serviceGestionFilmsActeurs.deleteFilm(num_film);
		
			System.out.println("liste des films de l'acteur 1 (apres suppression du film):");
			a1 = (ActeurV1) serviceGestionFilmsActeurs.getActeurWithFilmsById(1);
			for(FilmV1 fz : a1.getFilms())
				System.out.println("\t" + fz);
			
			f=(FilmV1) serviceGestionFilmsActeurs.getFilmById(num_film);
			Assert.assertTrue(f==null);
	}
	


}
