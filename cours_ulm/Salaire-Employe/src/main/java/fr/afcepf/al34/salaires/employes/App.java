package fr.afcepf.al34.salaires.employes;

public class App {

	public static void main(String[] args) {
		
		Commercial vendeur = new Vendeur();
		vendeur.nom = "KATZ";
		vendeur.prenom = "AXEL";
		vendeur.age = 35;
		vendeur.chiffreAffaires = 2000;
		System.out.println(vendeur.toString() + ", Salaire :  " + vendeur.calculerSalaire());
		
		Commercial representant = new Representant();
		representant.nom = "POMA";
		representant.prenom = "LIONEL";
		representant.age = 30;
		representant.chiffreAffaires = 2000;
		System.out.println(representant.toString() + ", Salaire :  " + representant.calculerSalaire());
		
		Technicien tech = new Technicien();
		tech.nom = "BOUSSABA";
		tech.prenom = "KHALED";
		tech.age = 29;
		tech.nbUniteProduite = 200;
		System.out.println(tech.toString() + ", Salaire :  " + tech.calculerSalaire());
		
		Technicien techRisque = new TechARisque();
		techRisque.nom = "De TOTO";
		techRisque.prenom = "TOTO";
		techRisque.age = 59;
		techRisque.nbUniteProduite = 200;
		System.out.println(techRisque.toString() + ", Salaire :  " + techRisque.calculerSalaire());
		
		System.out.println("----------");
		
		Personnel personnel = new Personnel();
		personnel.ajouterEmploye(vendeur);
		personnel.ajouterEmploye(representant);
		personnel.ajouterEmploye(tech);
		personnel.ajouterEmploye(techRisque);
		
		System.out.println("Salaire Total : " + personnel.calculerSalaires()); 
		System.out.println("Salaire moyen :  " + personnel.salaireMoyen());

	}

}
