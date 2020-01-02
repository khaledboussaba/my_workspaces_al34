package fr.afcepf.al34.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import fr.afcepf.al34.dto.ResCalculTva;
import fr.afcepf.al34.itf.ICalculTva;

public class CliRmiApp {

	public static void main(String[] args) {

		try {
			String machineServeur = "localhost"; //ou 192.168.xx.YY
			Registry registry = LocateRegistry.getRegistry(machineServeur, 1099);
			
			String nomLogiqueCalculateur = "calculateurTva";
			ICalculTva proxyCalculateurTva = (ICalculTva) registry.lookup(nomLogiqueCalculateur);
			
			double tva = proxyCalculateurTva.tva(200.0, 20.0);
			System.out.println("tva = " + tva);

			String auteur = proxyCalculateurTva.getAuteur();
			System.out.println("auteur = " + auteur);
			
			ResCalculTva resCalculTva = proxyCalculateurTva.tvaEtTtc(200.0, 20.0);
			System.out.println("résultat ttc = " + resCalculTva.getTtc());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
