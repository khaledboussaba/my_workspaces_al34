package tp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "film")
@NamedQueries({
	@NamedQuery(name = "Film.findAll", query = "SELECT f FROM Film f"),
	@NamedQuery(name = "Film.findByTitre", query = "SELECT f FROM Film f WHERE f.titre =: titreQueJeRecherche")
})
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_film")
	private Long idFilm;
	
	@Column(length = 128)
	private String titre;
	
	@Column(name = "date_sortie")
	@Temporal(TemporalType.DATE) // date sans heure
	private Date dateSortie;
	
	public Film(String titre, Date dateSortie) {
		super();
		this.titre = titre;
		this.dateSortie = dateSortie;
	}

	@Override
	public String toString() {
		return "Film [idFilm=" + idFilm + ", titre=" + titre + ", dateSortie=" + dateSortie + "]";
	}
	
}