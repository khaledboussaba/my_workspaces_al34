package tp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tp.entity.Produit;

public class ProduitDaoSimu implements ProduitDao {

	private Map<Long,Produit> simuProdMap = new HashMap<Long,Produit>();
	private long last_index=1L;
	
	@Override
	public Produit createProduit(Produit nouveauProduit) {
		nouveauProduit.setReference(this.last_index++);
		simuProdMap.put(nouveauProduit.getReference(), nouveauProduit);
		return nouveauProduit;
	}

	@Override
	public void deleteProduit(Produit p) {
		simuProdMap.remove(p.getReference());
	}

	@Override
	public List<Produit> getAllProduits() {
		return new java.util.ArrayList<Produit>(simuProdMap.values());
	}

	@Override
	public Produit getProduitByRef(long ref) {
		return simuProdMap.get(ref);
	}

	@Override
	public void updateProduit(Produit p) {
		Produit pp = simuProdMap.get(p.getReference());
		pp.setPrix(p.getPrix());
		pp.setLabel(p.getLabel());

	}

	@Override
	public void cleanUpResources() {
		simuProdMap.clear();
	}

}
