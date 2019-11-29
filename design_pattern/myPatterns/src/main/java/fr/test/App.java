package fr.test;

import fr.calculateur.Calculateur;
import fr.factory.MegaFactory;

public class App {

	public static void main(String[] args) {
		
		/*
		System.out.println("myApp");
		GoodLogger goodLogger  = new GoodLogger();
		goodLogger.log("essai log");
		*/
		Calculateur calculateur = MegaFactory.getInstance().createCalculateur();
		double resAdd=calculateur.addition(5, 6);
		System.out.println("resAdd="+resAdd);
		double resMult=calculateur.multiplication(5, 6);
		System.out.println("resMult="+resMult);
		
	}

}
