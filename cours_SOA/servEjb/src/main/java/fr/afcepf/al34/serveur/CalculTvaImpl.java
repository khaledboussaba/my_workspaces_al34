package fr.afcepf.al34.serveur;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.al34.dto.ResCalculTva;
import fr.afcepf.al34.itf.ICalculTva;

@Remote //ici ou sur l'interface
@Stateless
public class CalculTvaImpl implements ICalculTva {

	public double tva(double ht, double tauxTva)  {
		return ht * tauxTva / 100;
	}

	public double ttc(double ht, double tauxTva)  {
		return ht * (1 + tauxTva / 100);
	}

	public String getAuteur()  {
		return "Khaled / dév";
	}

	public ResCalculTva tvaEtTtc(double ht, double tauxTva)  {
		double tva = this.tva(ht, tauxTva);
		double ttc = this.ttc(ht, tauxTva);
		return new ResCalculTva(tva, ttc);
	}

}
