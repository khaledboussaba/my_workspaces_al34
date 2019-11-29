package tp.service;

public interface MyFacade {
	public GestionProduits getGestionProduits();
	public GestionConversion getGestionConversion();
	public GestionTva getGestionTva();
	
	public void cleanUpResources(); //si nécessaire (librérer ressources internes)

}
