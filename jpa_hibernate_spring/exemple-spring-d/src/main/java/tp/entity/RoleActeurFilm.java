package tp.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import tp.entity.pk.ActeurFilmPk;

@Getter @Setter
@Entity
@Table(name="role_acteur_film")
public class RoleActeurFilm {
	
	 @EmbeddedId 
	 private ActeurFilmPk pk ; 
	 
	 private String role;   
	 
	 @ManyToOne @JoinColumn(name="idActeur")     
	 @MapsId("idActeur") //pk.idActeur   
	 private Acteur acteur;  
	 
	 @ManyToOne @JoinColumn(name="idFilm")     
	 @MapsId("idFilm") //pk.idFilm 
	 private Film film; 
	 
	 public RoleActeurFilm() { 
		 super(); 
		 pk =  new ActeurFilmPk(); 
	}
	 public RoleActeurFilm(String role, Acteur acteur, Film film)  { 
		 super(); 
		 this.role = role; 
		 this.acteur = acteur; 
		 this.film = film; 
		 pk=new ActeurFilmPk(acteur.getId(), film.getId());
	} 

}
