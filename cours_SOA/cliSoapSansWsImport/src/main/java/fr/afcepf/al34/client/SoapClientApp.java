package fr.afcepf.al34.client;

import fr.afcepf.al34.ws.service.ICalculTva;

public class SoapClientApp {

	public static void main(String[] args) {
		
		ICalculTva calculateurTva = new CalculTvaDelegate();
		
		double prixTtc = calculateurTva.ttc(100.0, 10.0);
		String auteur = calculateurTva.getAuteur();
		System.out.println("ttc = " + prixTtc);
		System.out.println("auteur = " + auteur); 

	}

}
