package tp.service;

public class GestionConvImpl implements GestionConversion {

	public double euroToFrancs(double montant) {
		return montant * 6.5597;
	}

	public double francToEuros(double montant) {
		return montant / 6.5597;
	}

}
