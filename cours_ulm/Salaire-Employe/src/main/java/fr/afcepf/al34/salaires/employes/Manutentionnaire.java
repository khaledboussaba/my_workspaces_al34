package fr.afcepf.al34.salaires.employes;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("2de477b7-420e-4842-b61c-aa32667cf3b5")
public class Manutentionnaire extends Employe {
    @objid ("5cd6c6f7-bb03-4cb6-8427-b43c122ef779")
    private double nbHeuresTravailees;

    @objid ("dd983541-45dc-42a7-bcc5-f6b67a22c833")
    private static final double SALAIRE_HORAIRE = 20;

    @objid ("b8aa9488-2d75-42f0-87e0-62ef8b3dca40")
    public double calculerSalaire() {
    	return nbHeuresTravailees * SALAIRE_HORAIRE;
    }
    
    @Override
	public String getTitre() {
		return "Manutentionnaire : ";
	}

}
