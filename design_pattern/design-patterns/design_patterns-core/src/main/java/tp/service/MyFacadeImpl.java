package tp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.ioc.MyXmlBeanFactory;

public class MyFacadeImpl implements MyFacade {
	
    private static Logger logger = LoggerFactory.getLogger(MyFacadeImpl.class);
    
    private GestionConversion gestionConversion=null;
	private GestionTva gestionTva=null;
	private GestionProduits gestionProduits=null;
    
	private static MyFacadeImpl uniqueInstance = null;
	
	public synchronized static MyFacadeImpl getInstance()
	{
		if(uniqueInstance==null)
		{
			uniqueInstance=new MyFacadeImpl();
		}
		return uniqueInstance;
	}
	
	private MyFacadeImpl(){
		//En version "Agnostique", une façade cache entièrement la technologie
		// "Spring" , "CDI" ou "IOC maison" qui prend en charge les composants
		//derrière la façade
		
		MyXmlBeanFactory myXmlIocFactory = MyXmlBeanFactory.getInstance();
		myXmlIocFactory.initIocConfigFromXmlFile("myIocConfig.xml");
		this.gestionConversion = (GestionConversion) myXmlIocFactory.getBean("serviceGestionConversion");
		this.gestionTva = (GestionTva) myXmlIocFactory.getBean("serviceGestionTva");
		this.gestionProduits = (GestionProduits) myXmlIocFactory.getBean("serviceGestionProduits");
		logger.info("facade initialisee avec services gestionConversion , gestionTva et gestionProduits");
	}
	
	@Override
	public GestionProduits getGestionProduits() {
		return gestionProduits;
	}

	public GestionConversion getGestionConversion() {
		return gestionConversion;
	}

	public GestionTva getGestionTva() {
		return gestionTva;
	}
    /*
	public void setGestionConversion(GestionConversion gestionConversion) {
		this.gestionConversion = gestionConversion;
	}

	public void setGestionTva(GestionTva gestionTva) {
		this.gestionTva = gestionTva;
	}
    /*
	public void setGestionConversion(GestionConversion gestionConversion) {
		this.gestionConversion = gestionConversion;
	}

	public void setGestionTva(GestionTva gestionTva) {
		this.gestionTva = gestionTva;
	}
	*/

	@Override
	public void cleanUpResources() {
		gestionProduits.cleanUpResources(); //à adapter avec Spring ou autre sur vrai projet		
	}

	
	

}
