package tp.service;

import org.apache.commons.beanutils.BeanUtils;

import tp.dao.ProduitDao;
import tp.dto.ProduitDto;
import tp.entity.Produit;

/*
 * Classe d'implémentation locale du service métier "GestionProduits"
 *  - utilisation interne de "ProduitDao" injecté (IOC)
 *  - conversion interne de Entity --> DTO pour "valeurs de retour"
 *                          DTO --> Entity pour "param d'entrée"
 */

public class GestionProduitsImpl implements GestionProduits {

	private ProduitDao produitDao=null;
	
	// methode d'injection
	public void setProduitDao(ProduitDao produitDao) {
		this.produitDao = produitDao;
	}


	public ProduitDto getProduitByRef(String ref) {
		ProduitDto p=null;
		try {
			Produit prodEntity = produitDao.getProduitByRef(Long.parseLong(ref));
			p = new ProduitDto();
			BeanUtils.copyProperties(p,prodEntity); //version apache.commons.beanutil ==> (dest,src)
		    /* NB: copyProperties() recopie toutes les propriétés/attibuts de mêmes noms
		           d'un objet java dans un autre en effectuant si besoin des conversions
		           de types élémentaires
		     */
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return p;
	}


	@Override
	public void cleanUpResources() {
		this.produitDao.cleanUpResources();
	}


	@Override
	public void updateProduitViaDto(ProduitDto p) {
		//conversion DTO-->Entity via constructeur
		Produit prod = new Produit(Long.parseLong(p.getReference()),p.getLabel(),p.getPrix()) ;
		this.produitDao.updateProduit(prod);
	}

}
