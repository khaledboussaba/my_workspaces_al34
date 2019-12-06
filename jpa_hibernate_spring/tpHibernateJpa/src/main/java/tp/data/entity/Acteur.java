package tp.data.entity;

public class Acteur extends Personne {
	private long idActeur;

	public long getIdActeur() {
		return idActeur;
	}

	public void setIdActeur(long idActeur) {
		this.idActeur = idActeur;
	}

	@Override
	public String toString() {
		return "[" + idActeur+ "] " + " "+ this.getNom();
	}
	
	
	
}
