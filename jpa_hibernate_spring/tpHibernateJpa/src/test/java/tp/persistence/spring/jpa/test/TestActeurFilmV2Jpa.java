package tp.persistence.spring.jpa.test;


import java.util.Date;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tp.data.entity.ActeurV2;
import tp.data.entity.FilmV2;
import tp.data.entity.RoleActeurFilm;
import tp.persistence.spring.dao.GestionFilmsActeursRoles;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/springContext.xml"})
public class TestActeurFilmV2Jpa {
	
	@Inject
	private GestionFilmsActeursRoles serviceGestionFilmsActeursRoles = null; 
	    

	@Test
	public void testFilmsOfActeur(){
		System.out.println("***** testFilmsOfActeur V2 *****");
		ActeurV2 a = (ActeurV2) serviceGestionFilmsActeursRoles.getActeurWithFilmsById(1);
		System.out.println("Acteur " + a.toString());
		for(RoleActeurFilm r : a.getRolesFilms())
			System.out.println("\t role " + r.getRole() + " joue dans " + r.getFilm().toString());		
	}
	
	@Test
	public void testActeursOfFilm(){
		System.out.println("***** testActeursOfFilm V2 *****");
		FilmV2 f = (FilmV2) serviceGestionFilmsActeursRoles.getFilmWithActorsById(1);
		System.out.println("film " + f.toString());
		for(RoleActeurFilm r : f.getRolesActeurs())
			System.out.println("\t role " + r.getRole() + " joue par " + r.getActeur().toString());
	}
	
	@Test
	public void testNouveauFilmPourActeurV2() {
		FilmV2 f = null;
		ActeurV2 a1 = null;
				
			System.out.println("****** testNouveauFilmPourActeurV2 (n-n = (1-n) * (1-n) JPA) *****");
			
			// sequence habituelle : new , save , getAll , maj , update , get , delete 
			
			FilmV2 nouveauFilm = new FilmV2();
			nouveauFilm.setTitre("nom du nouveau film");
			nouveauFilm.setDate(new Date());
			nouveauFilm.setProducteur("nouveau producteur");
			serviceGestionFilmsActeursRoles.createFilm(nouveauFilm);
			long num_film = nouveauFilm.getIdFilm();
			
			System.out.println("id du nouveau film: " + num_film);
			
			a1 = (ActeurV2) serviceGestionFilmsActeursRoles.getActeurById(1);
			RoleActeurFilm r1 = new RoleActeurFilm("role1" , a1,nouveauFilm);
			ActeurV2 a2 = (ActeurV2)  serviceGestionFilmsActeursRoles.getActeurById(2);
			RoleActeurFilm r2 = new RoleActeurFilm("role2" , a2,nouveauFilm);
			
			serviceGestionFilmsActeursRoles.createRoleActeurFilm(r1);
			serviceGestionFilmsActeursRoles.createRoleActeurFilm(r2);
			
			
			//verif:
			
			System.out.println("liste des films de l'acteur 1 (apres insertion/sauvegarde nouveau film):");
			a1 = (ActeurV2)  serviceGestionFilmsActeursRoles.getActeurWithFilmsById(1);
			for(RoleActeurFilm r : a1.getRolesFilms())
				System.out.println("\t role " + r.getRole()  + " joue dans " + r.getFilm().toString());
			
			
			System.out.println("=== nouveau film (relu en base) =====");
			f = (FilmV2) serviceGestionFilmsActeursRoles.getFilmWithActorsById(num_film);
			System.out.println(f);
			Assert.assertTrue(f.getIdFilm()==num_film);
			Assert.assertTrue(f.getTitre().equals("nom du nouveau film"));
			for(RoleActeurFilm rx : f.getRolesActeurs())
				System.out.println("\t role " + rx.getRole() + " joue par " + rx.getActeur().toString());
			
			//mise a jour:
			
			f.setTitre("film_xy");
			serviceGestionFilmsActeursRoles.updateFilm(f);
			
			// verif mise a jour:
			
			f=(FilmV2) serviceGestionFilmsActeursRoles.getFilmById(num_film);
			Assert.assertTrue(f.getTitre().equals("film_xy"));
			System.out.println(f.toString());
			
			System.out.println("liste des films de l'acteur 1 (apres mise a jour du film):");
			a1 = (ActeurV2) serviceGestionFilmsActeursRoles.getActeurWithFilmsById(1);
			for(RoleActeurFilm ry : a1.getRolesFilms())
				System.out.println("\t role " + ry.getRole()  + " joue dans " + ry.getFilm().toString());
			
			serviceGestionFilmsActeursRoles.deleteFilm(num_film);
			
			
			System.out.println("liste des films de l'acteur 1 (apres suppression du film):");
			a1 = (ActeurV2) serviceGestionFilmsActeursRoles.getActeurWithFilmsById(1);
			//entityManager.refresh(a1);// pour que l'autre cote de la relation n-n soit au courant de la relation (cache m�moire � jour)
			for(RoleActeurFilm rz: a1.getRolesFilms())
				System.out.println("\t role " + rz.getRole()  + " joue dans " + rz.getFilm().toString());
			
			f=(FilmV2) serviceGestionFilmsActeursRoles.getFilmById(num_film);
			Assert.assertTrue(f==null);

	}




}
