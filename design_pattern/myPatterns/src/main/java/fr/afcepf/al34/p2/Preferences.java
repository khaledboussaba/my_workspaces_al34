package fr.afcepf.al34.p2;

public class Preferences {

	private String titre;
	private String prefixe;
	
	public Preferences() {
		this("titre inconnu", ">> ");
	}

	public Preferences(String titre, String prefixe) {
		super();
		this.titre = titre;
		this.prefixe = prefixe;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getPrefixe() {
		return prefixe;
	}

	public void setPrefixe(String prefixe) {
		this.prefixe = prefixe;
	}
	
}