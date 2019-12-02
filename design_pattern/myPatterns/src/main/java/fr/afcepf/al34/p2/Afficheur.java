package fr.afcepf.al34.p2;

import javax.swing.JOptionPane;

public class Afficheur {

	private Preferences preferences;
	
	private ContextAffichage contextAffichage;

	public void setContextAffichage(ContextAffichage contextAffichage) {
		this.contextAffichage = contextAffichage;
		this.preferences = this.contextAffichage.getPreferences();
	}

	public void afficher(Object o) {
		//System.out.println(o.toString());
		JOptionPane.showMessageDialog(null, this.preferences.getPrefixe() + o.toString(), this.preferences.getTitre(), 
				JOptionPane.INFORMATION_MESSAGE);
	}
	
}
