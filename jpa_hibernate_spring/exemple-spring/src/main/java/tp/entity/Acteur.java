package tp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "acteur")
@NamedQueries({
	@NamedQuery(name = "Acteur.findAll", query = "SELECT a FROM Acteur a")
})
public class Acteur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_acteur")
	private Long idActeur;
	
	private String nom;
	private String prenom;
	
	public Acteur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	
	@Override
	public String toString() {
		return "Acteur [idActeur=" + idActeur + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
}