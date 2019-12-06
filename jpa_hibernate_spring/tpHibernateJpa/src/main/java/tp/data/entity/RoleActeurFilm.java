package tp.data.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ActeurFilmV2")
public class RoleActeurFilm {
	private RoleActeurFilmCompositePk pk;
	private String role;
	
	private ActeurV2 acteur;
	private FilmV2 film;
	
	
	public RoleActeurFilm() {
		super();		
	}
	
	
	
	public RoleActeurFilm(String role, ActeurV2 acteur, FilmV2 film) {
		super();
		this.role = role;
		this.acteur = acteur;
		this.film = film;
		pk=new RoleActeurFilmCompositePk(acteur.getIdActeur(),film.getIdFilm());
		
	}


	@EmbeddedId
	public RoleActeurFilmCompositePk getPk() {
		return pk;
	}
	public void setPk(RoleActeurFilmCompositePk pk) {
		this.pk = pk;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@ManyToOne
	@JoinColumn(name="idActeur", insertable=false, updatable=false)
	public ActeurV2 getActeur() {
		return acteur;
	}
	public void setActeur(ActeurV2 acteur) {
		this.acteur = acteur;
	}
	
	@ManyToOne
	@JoinColumn(name="idFilm" , insertable=false, updatable=false)
	public FilmV2 getFilm() {
		return film;
	}
	public void setFilm(FilmV2 film) {
		this.film = film;
	}
	
	
	 
	
	
}
