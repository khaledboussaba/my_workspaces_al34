package fr.afcepf.al34.salaires.employes;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("05c39d6b-6156-4e6d-901a-8020f62e266f")
public class ManutARisque extends Manutentionnaire implements ARisque {
    @objid ("5bf620a2-2617-41a4-b470-b0d6664c6abe")
    public double calculerSalaire() {
    	return super.calculerSalaire() + PRIME_RISQUE;
    }

}
