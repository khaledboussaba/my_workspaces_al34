package tp.data.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RoleActeurFilmCompositePk implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long idActeur;
	private long idFilm;
	
	public RoleActeurFilmCompositePk() {
		super();
	}
	public RoleActeurFilmCompositePk(long idActeur, long idFilm) {
		super();
		this.idActeur = idActeur;
		this.idFilm = idFilm;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idActeur ^ (idActeur >>> 32));
		result = prime * result + (int) (idFilm ^ (idFilm >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final RoleActeurFilmCompositePk other = (RoleActeurFilmCompositePk) obj;
		if (idActeur != other.idActeur)
			return false;
		if (idFilm != other.idFilm)
			return false;
		return true;
	}
	public long getIdActeur() {
		return idActeur;
	}
	public void setIdActeur(long idActeur) {
		this.idActeur = idActeur;
	}
	public long getIdFilm() {
		return idFilm;
	}
	public void setIdFilm(long idFilm) {
		this.idFilm = idFilm;
	}
	
	
}
