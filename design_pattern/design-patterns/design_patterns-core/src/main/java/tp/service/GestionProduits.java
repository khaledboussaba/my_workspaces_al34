package tp.service;

import tp.dto.ProduitDto;

/*
 * interface du service métier "GestionProduits" (avec DTO)
 */

public interface GestionProduits {
	
	public ProduitDto getProduitByRef(String ref);
	//+ autres méthodes (avec plus du temps pour tout programmer)
	public void updateProduitViaDto(ProduitDto p);
	
	public void cleanUpResources(); //si nécessaire (librérer ressources internes)

}
