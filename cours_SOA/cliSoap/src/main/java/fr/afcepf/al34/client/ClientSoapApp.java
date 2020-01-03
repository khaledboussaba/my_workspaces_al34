package fr.afcepf.al34.client;

import fr.afcepf.al34.dto.ResCalculTva;
import fr.afcepf.al34.serveur.CalculTvaImplService;
import fr.afcepf.al34.serveur.ICalculTva;

public class ClientSoapApp {

	public static void main(String[] args) {

		ICalculTva proxyWSTva = (new CalculTvaImplService()).getCalculTvaImplPort();
		String auteur = proxyWSTva.getAuteur();
		System.out.println(auteur);
		
		ResCalculTva res = proxyWSTva.tvaEtTtc(200, 20);
		System.out.println("tva = " + res.getTva());
		System.out.println("ttc = " + res.getTtc());
	}

}
