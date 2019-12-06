package tp.persistence.spring.jpa;

import java.util.Collection;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import tp.data.entity.Acteur;
import tp.data.entity.ActeurV1;
import tp.data.entity.ActeurV2;
import tp.data.entity.Film;
import tp.data.entity.FilmV2;
import tp.data.entity.RoleActeurFilm;
import tp.data.entity.RoleActeurFilmCompositePk;
import tp.persistence.spring.dao.GestionFilmsActeursRoles;

@Named
@Transactional
@Qualifier("v2") //Attention : ici @Qualifier en version "Spring" (pas CDI)
public class GestionFilmsActeursImplV2 extends GestionFilmsActeursImplAbstract 
                                       implements GestionFilmsActeursRoles{
	

	public long createActeur(Acteur acteur) {
		if(!(acteur instanceof ActeurV2)) 
			throw new RuntimeException("acteur doit etre de type ActeurV2");
		return super.createActeur(acteur);
	}

	public long createFilm(Film film) {
		if(!(film instanceof FilmV2)) 
			throw new RuntimeException("film doit etre de type FilmV2");
		return super.createFilm(film);
	}

	public Acteur getActeurById(long idActeur) {
		return entityManager.find(ActeurV2.class, idActeur);
	}
	
	public Acteur getActeurWithFilmsById(long idActeur) {
		ActeurV2 a = entityManager.find(ActeurV2.class, idActeur);
		for(RoleActeurFilm raf : a.getRolesFilms()){
			raf.getFilm();
		}
		return a;
	}

	public Collection<Acteur> getAllActeur() {
		return entityManager.createQuery("Select a from ActeurV2 as a",Acteur.class)
							.getResultList();
	}

	public Collection<Film> getAllFilm() {
		return entityManager.createQuery("Select f from FilmV2 as f",Film.class)
							.getResultList();
	}

	public Film getFilmById(long idFilm) {
		return entityManager.find(FilmV2.class, idFilm);
	}
	
	public Film getFilmWithActorsById(long idFilm) {
		FilmV2 film = entityManager.find(FilmV2.class, idFilm);
		for(RoleActeurFilm raf : film.getRolesActeurs()){
			raf.getActeur();
		}
		return film;
	}
	
	public void deleteFilm(long idFilm) {
		FilmV2 film  = (FilmV2) this.getFilmById(idFilm);
		
		// Attention , il faut d'abord supprimer les RolesActeurs avant de  supprimer le film 
		// (==> sinon : pb contrainte integrite referentielle)
			
		for(RoleActeurFilm raf : film.getRolesActeurs())
						entityManager.remove(raf);
		entityManager.flush();// pour bien controler l'ordre
					
		entityManager.remove(film); 
	}

	public RoleActeurFilmCompositePk createRoleActeurFilm(
			RoleActeurFilm roleActeurFilm) {
		entityManager.persist(roleActeurFilm);
		return roleActeurFilm.getPk();
	}

	public void deleteRoleActeurFilm(long idActeur, long idFilm) {
		RoleActeurFilm r  = (RoleActeurFilm) 
		     entityManager.find(RoleActeurFilm.class,
		    		            new RoleActeurFilmCompositePk(idActeur, idFilm));
		entityManager.remove(r); 
	}
	
	public void updateRoleActeurFilm(RoleActeurFilm roleActeurFilm) {
		entityManager.merge(roleActeurFilm);
		
	}

	@Override
	public void attachActorToFilm(Film f, Acteur a) {
		ActeurV2 pa = entityManager.find(ActeurV2.class, a.getIdActeur());
		FilmV2 pf = entityManager.find(FilmV2.class, f.getIdFilm());
		RoleActeurFilm raf = new RoleActeurFilm("role_inconnu" , pa,pf);
		entityManager.persist(raf); //a peaufiner
	}


	
}
