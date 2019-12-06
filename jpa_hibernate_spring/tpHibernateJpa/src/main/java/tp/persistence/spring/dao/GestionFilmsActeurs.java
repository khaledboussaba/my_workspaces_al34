package tp.persistence.spring.dao;

import java.util.Collection;

import tp.data.entity.Acteur;
import tp.data.entity.Film;

public interface GestionFilmsActeurs {
	
    // CRUD - film
	public Film getFilmById(long idFilm);
	public Film getFilmWithActorsById(long idFilm);
	public Collection<Film> getAllFilm();
	
	public long createFilm(Film film);// return pk
	public void updateFilm(Film film);
	public void deleteFilm(long idFilm);
	
	 // CRUD - acteur
	public Acteur getActeurById(long idActeur);
	public Acteur getActeurWithFilmsById(long idActeur);
	public Collection<Acteur> getAllActeur();
	
	public long createActeur(Acteur acteur);// return pk
	public void updateActeur(Acteur acteur);
	public void deleteActeur(long idActeur);	

    // Autres methodes:
	public void attachActorToFilm(Film f, Acteur a);

}
