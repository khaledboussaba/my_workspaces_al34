package fr.al34.serveur;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServeurRmiApp {

	public static void main(String[] args) {

		try {
			//initialiser un serveur de noms logiques RMI(numéro de port = 1099)
			//qui fonctionne sur le même ordinateur que ce serveur de traitement
			//pas besoin de lancer préalablement "RmiRegistry" du jdk/bin
			Registry registry = LocateRegistry.createRegistry(1099);
			
			CalculTvaImpl calculateurTva = new CalculTvaImpl();
			String nomLogiqueCalculateur = "calculateurTva";
			//Naming.rebind(nomLogiqueCalculateur, calculateurTva);
			registry.rebind(nomLogiqueCalculateur, calculateurTva);
			//une tache de fonf est automatiquement gérée par RMI pour attendre et traiter les futures requêtes entrantes
			System.out.println("serveur RMI démarré !");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
