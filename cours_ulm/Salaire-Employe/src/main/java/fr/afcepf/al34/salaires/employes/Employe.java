package fr.afcepf.al34.salaires.employes;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("95c85a85-7a26-4fb8-be82-153bf28bf888")
public abstract class Employe {
    @objid ("5b08024c-c470-4c2d-be87-88d4b669dcc1")
    protected String nom;

    @objid ("91ab91ce-ced0-438a-997a-7cbfa7f3da84")
    protected String prenom;

    @objid ("0547c361-3771-419b-84b1-b99a97934c6b")
    protected int age;

    @objid ("7812af1b-6476-4fb9-8520-8bc71b47ccb4")
    public abstract double calculerSalaire();

    @objid ("b9b77a75-0bdf-4eac-9b50-4cdd47ad38e2")
    public String toString() {
    	return getTitre() + nom + " " + prenom + ", " + age +" ans";
    }

    @objid ("16facc2d-6d65-401a-b357-b55e3f5554fe")
    public String getTitre() {
    	return "L'emloyé ";
    }
    

}
