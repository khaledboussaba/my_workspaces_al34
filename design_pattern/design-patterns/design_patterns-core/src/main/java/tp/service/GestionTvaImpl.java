package tp.service;

public class GestionTvaImpl implements GestionTva {

	public double getTva(double taux, double montantHt) {
		return montantHt * (1+taux/100);
	}

}
