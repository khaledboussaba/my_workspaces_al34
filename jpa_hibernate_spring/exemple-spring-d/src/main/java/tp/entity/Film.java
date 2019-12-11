package tp.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name="film")
@NamedQueries({
	@NamedQuery(name = "Film.findAll" , query = "SELECT f FROM Film f"),
	@NamedQuery(name = "Film.findByTitre" , query = "SELECT f FROM Film f WHERE f.titre=:titre")
})
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto_incr coté base
	                                   //+ remontée valeur en mémoire
	private Long id;
	
	@Column(length=128) //VARCHAR(128) dans CREATE_TABLE
	private String titre;
	
	@Column(name="date_sortie")
	@Temporal(TemporalType.DATE) //date sans heure
	private Date dateSortie;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "film_producteur",
		joinColumns = {@JoinColumn(name="id_film")},
		inverseJoinColumns = {@JoinColumn(name="id_producteur")})
	private List<Producteur> producteurs ;
	
	@OneToMany(mappedBy="film") 
	private List<RoleActeurFilm> rolesActeurs ; 
	
	public void addProducteur(Producteur p) {
		if(this.producteurs==null) {
			this.producteurs = new ArrayList<>();
		}
		producteurs.add(p);
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", titre=" + titre + ", dateSortie=" + dateSortie + "]";
	}


	public Film(Long id, String titre, Date dateSortie) {
		super();
		this.id = id;
		this.titre = titre;
		this.dateSortie = dateSortie;
	}
	
	

}
