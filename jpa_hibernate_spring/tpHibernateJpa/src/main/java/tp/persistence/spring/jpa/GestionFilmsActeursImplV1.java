package tp.persistence.spring.jpa;

import java.util.Collection;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import tp.data.entity.Acteur;
import tp.data.entity.ActeurV1;
import tp.data.entity.Film;
import tp.data.entity.FilmV1;

@Named
@Transactional
@Qualifier("v1") //Attention : ici @Qualifier en version "Spring" (pas CDI)
public class GestionFilmsActeursImplV1 extends GestionFilmsActeursImplAbstract {
	

	public long createActeur(Acteur acteur) {
		if(!(acteur instanceof ActeurV1)) 
			throw new RuntimeException("acteur doit etre de type ActeurV1");
		return super.createActeur(acteur);
	}

	public long createFilm(Film film) {
		if(!(film instanceof FilmV1)) 
			throw new RuntimeException("film doit etre de type FilmV1");
		return super.createFilm(film);
	}

	public Acteur getActeurById(long idActeur) {
		return entityManager.find(ActeurV1.class, idActeur);
	}
	public Acteur getActeurWithFilmsById(long idActeur) {
		ActeurV1 a = entityManager.find(ActeurV1.class, idActeur);
		a.getFilms().size();//dans methode @Transactional pour eviter lazy ex
		                    //autre solution: query/select avec "fetch"
		return a;
	}

	public Collection<Acteur> getAllActeur() {
		return entityManager.createQuery("Select a from ActeurV1 as a",Acteur.class)
		                    .getResultList();
	}

	public Collection<Film> getAllFilm() {
		return entityManager.createQuery("Select f from FilmV1 as f",Film.class)
							.getResultList();
	}

	public Film getFilmById(long idFilm) {
		return entityManager.find(FilmV1.class, idFilm);
	}
	
	public Film getFilmWithActorsById(long idFilm) {
		FilmV1 film =  entityManager.find(FilmV1.class, idFilm);
		film.getActeurs().size();//dans methode @Transactional pour eviter lazy exception
		return film;
	}

	public void deleteFilm(long idFilm) {
		FilmV1 film  = (FilmV1) this.getFilmById(idFilm);

		// Attention , il faut detacher le film des acteurs avant de le supprimer 
		//(==> sinon : pb contrainte integrite referentielle)
		
		for(ActeurV1 a : film.getActeurs()){
			a.getFilms().remove(film);
		}
		film.removeAllActeur();//f.getActeurs().clear(); 
		
		entityManager.remove(film); 
	}

	@Override
	public void attachActorToFilm(Film f, Acteur a) {
		FilmV1 pf = (FilmV1) entityManager.find(FilmV1.class,f.getIdFilm());//rendu persitant
		ActeurV1 pa = (ActeurV1) entityManager.find(ActeurV1.class,a.getIdActeur());//rendu persitant
		pf.addActeur(pa);
		pa.addFilm(pf);
		//repercussion automatique en base lors du commit/flush
	}

	
}
