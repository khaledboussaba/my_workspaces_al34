package fr.al34.serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import fr.al34.itf.ICalculTva;

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

}
