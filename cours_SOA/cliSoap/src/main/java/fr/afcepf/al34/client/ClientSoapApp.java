package fr.afcepf.al34.client;

import java.net.URL;

import fr.afcepf.al34.dto.ResCalculTva;
import fr.afcepf.al34.serveur.CalculTvaImplService;
import fr.afcepf.al34.serveur.ICalculTva;

public class ClientSoapApp {

	public static void main(String[] args) {
		try {
			//URL wsdlUrl = new URL("http://localhost:8080/servEjb/CalculTvaImpl?wsdl");
			// Le serveur jboss accepte des requetes autres que localhost si l'option -b 0.0.0.0 
			// est précisée au lancement du serveur (depuis eclipse ou pas)
			URL wsdlUrl = new URL("http://192.168.102.183:8080/servEjb/CalculTvaImpl?wsdl");
			
			ICalculTva proxyWSTva = (new CalculTvaImplService(wsdlUrl)).getCalculTvaImplPort();
			String auteur = proxyWSTva.getAuteur();
			System.out.println(auteur);
			
			ResCalculTva res = proxyWSTva.tvaEtTtc(200, 20);
			System.out.println("tva = " + res.getTva());
			System.out.println("ttc = " + res.getTtc());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
