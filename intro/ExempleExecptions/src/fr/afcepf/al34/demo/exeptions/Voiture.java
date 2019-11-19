package fr.afcepf.al34.demo.exeptions;

public class Voiture {

	// Attributs
	private String couleur;
	private int cylindree;
	private int puissance;
	private int vitesseCourante;
	private boolean manual;

	//Constructeur
	
	//1
	public Voiture() {
		manual = true;
		couleur = "blanche";
	}
	//2
	public Voiture(String couleur) {
		this.couleur = couleur;
	}
	//3
	public Voiture(String couleur, int puissance, int cylindree) {
		this(couleur); //appelle le constructeur 2
		this.puissance = puissance;
		this.cylindree = cylindree;
	}
	//4
	public Voiture(String couleur, int puissance, int cylindree, boolean manual) {
		this(couleur, puissance, cylindree); //appelle le constructeur 3 et 2
		this.manual = manual;
	}

	// Méthodes
	public void accelerer(int niveau) {
		vitesseCourante += (cylindree + puissance) * niveau;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public int getCylindree() {
		return cylindree;
	}

	public void setCylindree(int cylindree) {
		this.cylindree = cylindree;
	}

	public int getPuissance() {
		return puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}

	public boolean isManual() {
		return manual;
	}

	public void setManual(boolean manual) {
		this.manual = manual;
	}

	public int getVitesseCourante() {
		return vitesseCourante;
	}

}
