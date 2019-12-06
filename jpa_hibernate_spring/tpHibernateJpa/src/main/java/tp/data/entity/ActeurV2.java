package tp.data.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


// V2 : relation n-n avec infos supplementaire dans table de jointure
@Entity
@Table(name="Acteur")
public class ActeurV2 extends Acteur {

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



	private List<RoleActeurFilm> rolesFilms;
	
	@OneToMany(mappedBy="acteur")
	public List<RoleActeurFilm> getRolesFilms() {
		return rolesFilms;
	}

	public void setRolesFilms(List<RoleActeurFilm> rolesFilms) {
		this.rolesFilms = rolesFilms;
	}
	
	
	
}
