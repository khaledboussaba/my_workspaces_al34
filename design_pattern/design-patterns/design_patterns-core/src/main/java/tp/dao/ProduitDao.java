package tp.dao;

import java.util.List;

import tp.entity.Produit;

/*
 * interface d'un Data Access Object
 * avec methodes C.R.U.D. (Create,Retreive,Update,Delete)
 * NB: les exceptions evenutuellement soulevees 
 * remontent si besoin en tant que RuntimeException .
 * 
 */

public interface ProduitDao {
	
	public Produit getProduitByRef(long ref);
	public List<Produit> getAllProduits();
	public Produit createProduit(Produit nouveauProduit);
	public void updateProduit(Produit p);
	public void deleteProduit(Produit p);
	public void cleanUpResources(); //si nécessaire (librérer ressources internes)

}
