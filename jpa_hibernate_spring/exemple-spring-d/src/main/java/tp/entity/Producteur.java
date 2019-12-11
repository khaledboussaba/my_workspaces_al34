package tp.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@NamedQueries({
	@NamedQuery(name = "Producteur.findAll" , query = "SELECT p FROM Producteur p")
})
public class Producteur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;//null ou pas
	private String nom;
	private String prenom;
	
	@ManyToMany(fetch = FetchType.LAZY,mappedBy = "producteurs")
	private List<Film> films;
	
	
	public Producteur(Long id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}


	@Override
	public String toString() {
		return "Producteur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}


	
	
}
