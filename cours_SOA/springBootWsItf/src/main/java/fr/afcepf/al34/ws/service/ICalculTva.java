package fr.afcepf.al34.ws.service;

import javax.jws.WebParam;
import javax.jws.WebService;

import fr.afcepf.al34.ws.dto.ResCalculTva;

@WebService
public interface ICalculTva {

	double tva(@WebParam(name="ht")double ht, @WebParam(name="tauxTva")double tauxTva);
	double ttc(@WebParam(name="ht")double ht, @WebParam(name="tauxTva")double tauxTva);
	ResCalculTva tvaEtTtc(@WebParam(name="ht")double ht, @WebParam(name="tauxTva")double tauxTva);
	String getAuteur();
	
}
