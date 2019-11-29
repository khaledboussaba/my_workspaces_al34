package fr.calculateur;

public class CalculateurBasic implements Calculateur {

	@Override
	public double addition(double a, double b) {
		return a + b;
	}

	@Override
	public double multiplication(double a, double b) {
		return a * b;
	}

}
