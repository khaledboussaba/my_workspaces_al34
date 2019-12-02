package fr.calculateur;

public abstract class CalculateurDecorateur implements Calculateur {
	
	protected Calculateur calculateur;//calculateur de base à décorer
	
	public CalculateurDecorateur() {
		this(null);
	}
	public CalculateurDecorateur(Calculateur calculateur) {
		super();
		this.calculateur = calculateur;
	}
	public Calculateur getCalculateur() {
		return calculateur;
	}
	public void setCalculateur(Calculateur calculateur) {
		this.calculateur = calculateur;
	}
	
	@Override
	public double addition(double a, double b) {
		return calculateur.addition(a, b);
	}

	@Override
	public double multiplication(double a, double b) {
		return calculateur.multiplication(a, b);
	}

}