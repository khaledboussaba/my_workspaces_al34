package fr.afcepf.al34.itf;

import java.rmi.Remote;
import java.rmi.RemoteException;

import fr.afcepf.al34.dto.ResCalculTva;

public interface ICalculTva extends Remote {

	double tva(double ht, double tauxTva) throws RemoteException;
	double ttc(double ht, double tauxTva) throws RemoteException;
	ResCalculTva tvaEtTtc(double ht, double tauxTva) throws RemoteException;
	String getAuteur() throws RemoteException;
	
}
