package fr.afcepf.al34.ws.service;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

import fr.afcepf.al34.ws.dto.ResCalculTva;

@Service //ou @Component de spring
@WebService(endpointInterface = "fr.afcepf.al34.ws.service.ICalculTva")
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