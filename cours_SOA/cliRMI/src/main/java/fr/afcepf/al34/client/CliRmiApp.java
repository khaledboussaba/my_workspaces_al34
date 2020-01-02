package fr.afcepf.al34.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import fr.afcepf.al34.itf.ICalculTva;

public class CliRmiApp {

	public static void main(String[] args) {

		try {
			String machineServeur = "192.168.102.183"; //ou 192.168.xx.YY
			Registry registry = LocateRegistry.getRegistry(machineServeur, 1099);
			String nomLogiqueCalculateur = "calculateurTva";
			ICalculTva proxyCalculateurTva = (ICalculTva) registry.lookup(nomLogiqueCalculateur);
			double tva = proxyCalculateurTva.tva(200.0, 20.0);
			String auteur = proxyCalculateurTva.getAuteur();
			System.out.println("tva = " + tva);
			System.out.println("auteur = " + auteur);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
