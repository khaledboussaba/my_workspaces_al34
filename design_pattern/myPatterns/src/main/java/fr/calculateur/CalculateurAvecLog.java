package fr.calculateur;

import java.text.MessageFormat;

import fr.annotation.MyInject;
import fr.factory.MegaFactory;
import fr.factory.MegaFactoryAvecInjection;
import fr.logger.MyLogger;

public class CalculateurAvecLog implements Calculateur {

	@MyInject //@Inject ou @Autowired // demande a initialiser myLogger
	private MyLogger myLogger;
	
	private String commentaireQuiVaBien = "You know what, I am happy !!!";

	public CalculateurAvecLog() {
		//myLogger = MegaFactory.getInstance().createLogger();
		
		//dans un vrai projet Spring, EJB ou autre, pas besoin de faire l'appel ci dessous, c'est fait automatiquement
		MegaFactoryAvecInjection.injectDependenciesInObject(this);
	}

	@Override
	public double addition(double a, double b) {
		double res = a + b;
		myLogger.log(MessageFormat.format("addition({0},{1})={2}", a,b,res));
		return res;
	}

	@Override
	public double multiplication(double a, double b) {
		double res = a * b;
		myLogger.log(MessageFormat.format("multiplication({0},{1})={2}", a,b,res));
		return res;
	}

}
