package fr.afcepf.al34.appX.service;

import javax.ejb.Remote;
import javax.ejb.Stateless;

//@Local
@Remote
@Stateless
public class ServiceXxImpl implements ServiceXx{

	@Override
	public Double euroToFranc(Double montant) {
		return montant * 6.55957;
	}

	
}
