package fr.afcepf.al34.demo.vehicules;

import java.util.Random;

public class App {

	public static void main(String[] args) {

		//déclaration d'une variable:
		Voiture v;
		//affectation d'une nouvelle instance
		//v = new Voiture();
		v = new Voiture("rouge");
		
		v.setCylindree(1000);
		v.setPuissance(230);
		
		v.accelerer(42);
		
		int vitesse = v.getVitesseCourante();
		System.out.println(vitesse);
		
	}

}
