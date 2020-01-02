package fr.afcepf.al34.serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import fr.afcepf.al34.dto.ResCalculTva;
import fr.afcepf.al34.itf.ICalculTva;

public class CalculTvaImpl extends UnicastRemoteObject implements ICalculTva {
	private static final long serialVersionUID = -5295667554668187960L;

	protected CalculTvaImpl() throws RemoteException {
		super(); //appel indispensable du constructeur de UnicastRemoteObject pour que l'objet soit accessible à distance via RMI
	}

	public double tva(double ht, double tauxTva) throws RemoteException {
		return ht * tauxTva / 100;
	}

	public double ttc(double ht, double tauxTva) throws RemoteException {
		return ht * (1 + tauxTva / 100);
	}

	public String getAuteur() throws RemoteException {
		return "Khaled / dév";
	}

	public ResCalculTva tvaEtTtc(double ht, double tauxTva) throws RemoteException {
		double tva = this.tva(ht, tauxTva);
		double ttc = this.ttc(ht, tauxTva);
		return new ResCalculTva(tva, ttc);
	}

}
