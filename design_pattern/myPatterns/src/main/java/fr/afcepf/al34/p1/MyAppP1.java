package fr.afcepf.al34.p1;

import fr.afcepf.al34.p2.Afficheur;
import fr.afcepf.al34.p2.ContextAffichage;
import fr.afcepf.al34.p2.Preferences;

public class MyAppP1 implements ContextAffichage {

	private Afficheur afficheur = new Afficheur();
	private String data = "Données à afficher";
	
	public static void main(String[] args) {
		
		(new MyAppP1()).tache();
	}
	
	public void tache() {
		afficheur.setContextAffichage(this);
		afficheur.afficher(data);
	}
	
	public Preferences getPreferences() {
		return new Preferences("p1", "***");
	}
	
}
