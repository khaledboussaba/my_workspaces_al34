package tp.entity.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

import lombok.NoArgsConstructor;

@Embeddable
@Getter @Setter @NoArgsConstructor
public class ActeurFilmPk implements Serializable{
	private Long idFilm;
	private Long idActeur;
	
	public ActeurFilmPk(Long idFilm, Long idActeur) {
		super();
		this.idFilm = idFilm;
		this.idActeur = idActeur;
	}
	
}
