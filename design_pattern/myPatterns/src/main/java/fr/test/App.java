package fr.test;

import fr.calculateur.Calculateur;
import fr.factory.MegaFactory;
import fr.logger.MyLogger;

public class App {

	public static void main(String[] args) {
		
		/*
		System.out.println("myApp");
		GoodLogger goodLogger  = new GoodLogger();
		goodLogger.log("essai log");
		*/
		/*
		Calculateur calculateur = MegaFactory.getInstance().createCalculateur();
		double resAdd=calculateur.addition(5, 6);
		System.out.println("resAdd="+resAdd);
		double resMult=calculateur.multiplication(5, 6);
		System.out.println("resMult="+resMult);
		*/
		/*
		System.out.println("myApp");
		MyLogger goodLogger  = MegaFactory.getInstance().create(MyLogger.class);
		goodLogger.log("essai log");
		*/
		Calculateur calculateur = MegaFactory.getInstance().create(Calculateur.class);
		double resAdd=calculateur.addition(5, 6);
		System.out.println("resAdd="+resAdd);
		double resMult=calculateur.multiplication(5, 6);
		System.out.println("resMult="+resMult);
		
	}

}