package tp.data.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


//V2 : relation n-n avec infos supplementaire dans table de jointure
@Entity
@Table(name="Film")
public class FilmV2 extends Film {
	
	private List<RoleActeurFilm> rolesActeurs;

	@Column(name="dateSortie")
	public Date getDate() {
		return super.getDate();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdFilm() {
		return super.getIdFilm();
	}
	public String getProducteur() {
		return super.getProducteur();
	}

	public String getTitre() {
		return super.getTitre();
	}

	
	@OneToMany(mappedBy="film")
	public List<RoleActeurFilm> getRolesActeurs() {
		return rolesActeurs;
	}

	public void setRolesActeurs(List<RoleActeurFilm> rolesActeurs) {
		this.rolesActeurs = rolesActeurs;
	}

	
	

}
