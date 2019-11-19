package fr.afcepf.al34.salaires.employes;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("d25b2461-140e-4dc8-843a-9dc15f58a317")
public class Vendeur extends Commercial {
    @objid ("25194888-fbe4-47c8-8fac-d348e47200c8")
    private static final double POURCENTAGE_VENDEUR = 0.20;

    @objid ("1dce460b-77b0-452b-828c-3eec8693da3c")
    public double calculerSalaire() {
    	return super.chiffreAffaires * POURCENTAGE_VENDEUR;
    }

	@Override
	public String getTitre() {
		return "Vendeur : ";
	}

}
