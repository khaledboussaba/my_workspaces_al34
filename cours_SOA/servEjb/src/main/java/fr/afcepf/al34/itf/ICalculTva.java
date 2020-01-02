package fr.afcepf.al34.itf;

import fr.afcepf.al34.dto.ResCalculTva;

public interface ICalculTva {

	double tva(double ht, double tauxTva);
	double ttc(double ht, double tauxTva);
	ResCalculTva tvaEtTtc(double ht, double tauxTva);
	String getAuteur();
	
}
