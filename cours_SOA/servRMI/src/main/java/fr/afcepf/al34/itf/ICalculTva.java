package fr.afcepf.al34.itf;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalculTva extends Remote {

	double tva(double ht, double tauxTva) throws RemoteException;
	double ttc(double ht, double tauxTva) throws RemoteException;
	String getAuteur() throws RemoteException;
	
}
