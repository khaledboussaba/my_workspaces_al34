package tp.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


// V1 : relation n-n sans infos supplementaire dans table de jointure

@Entity
@Table(name="Acteur")
public class ActeurV1 extends Acteur {

	private List<FilmV1> films;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdActeur() {
		return super.getIdActeur();
	}

	
	
	@Override
	public String getNom() {
		return super.getNom();
	}



	/*
	public String getPrenom() {
		return super.getPrenom();
	}*/



	@ManyToMany(mappedBy="acteurs" )
	/*@JoinTable(name="ActeurFilmV1",
			   joinColumns={@JoinColumn(name="idActeur")},
			   inverseJoinColumns={@JoinColumn(name="idFilm")})*/
	public List<FilmV1> getFilms() {
		return films;
	}

	public void setFilms(List<FilmV1> films) {
		this.films = films;
	}
	
	public void addFilm(FilmV1 f){
		if(films==null)
			films = new ArrayList<FilmV1>();
		films.add(f); 
	}
	
	public void removeFilm(FilmV1 f){
		if(films!=null)
			films.remove(f);
	}
	
    public void removeAllFilm(){
    	if(films!=null)
	    	films.clear();
	}
	
	
}
