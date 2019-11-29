package fr.calculateur;

import java.text.MessageFormat;

import fr.factory.MegaFactory;
import fr.logger.MyLogger;

public class CalculateurAvecLog implements Calculateur {

	MyLogger myLogger = null;

	public CalculateurAvecLog() {
		myLogger = MegaFactory.getInstance().createLogger();
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
