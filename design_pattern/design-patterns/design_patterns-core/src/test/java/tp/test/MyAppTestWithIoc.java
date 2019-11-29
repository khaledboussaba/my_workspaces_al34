package tp.test;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.dao.ProduitDao;
import tp.entity.Produit;
import tp.ioc.MyXmlBeanFactory;

public class MyAppTestWithIoc {
	
	private static Logger logger = LoggerFactory.getLogger(MyAppTestWithIoc.class);
	
	private ProduitDao produitDao; //chose à  tester

    //pour eventuel lancement "run as / java appli"
	public static void main(String[] args) {
		MyAppTestWithIoc thisApp = new MyAppTestWithIoc();
		thisApp.setUp();
		thisApp.testProduitDao();
		thisApp.clean();
		//System.exit(0);
	}
	
	@Before
	public void setUp(){
		MyXmlBeanFactory myXmlIocFactory = MyXmlBeanFactory.getInstance();
		myXmlIocFactory.initIocConfigFromXmlFile("myIocConfig.xml");
		this.produitDao = (ProduitDao) myXmlIocFactory.getBean("produitDao");
	}
	
	@After
	public void clean(){
		this.produitDao.cleanUpResources();
	}
	
	//@Test
	public void listerTousLesProduits()
	{
		List<Produit> listProd = produitDao.getAllProduits();
		Assert.assertNotNull(listProd);
		logger.info("liste des produits ==>");
		for(Produit p : listProd)
			logger.info(p.toString());
	}
	
	
	@Test
	public void testProduitDao()
	{
        
        listerTousLesProduits();
        
        Produit nouveauProduit = new Produit(null,"nouveau produit XY",26.6);
        nouveauProduit = produitDao.createProduit(nouveauProduit);
        Long ref = nouveauProduit.getReference();
        Assert.assertNotNull(ref);
        Produit prod = produitDao.getProduitByRef(ref);
        Assert.assertTrue(prod.getLabel().equals("nouveau produit XY"));
        Assert.assertEquals(26.6, prod.getPrix(), 0.00001);
        logger.info("nouveau produit (with ref="+ ref + "):");
        logger.info(prod.toString());
        
        prod.setLabel("nouveau label");
        prod.setPrix(65.2);
        produitDao.updateProduit(prod);
        
        prod = produitDao.getProduitByRef(ref);
        Assert.assertTrue(prod.getLabel().equals("nouveau label"));
        Assert.assertEquals(65.2, prod.getPrix(), 0.00001);
        logger.info("nouveau produit modifie:");
        logger.info(prod.toString());
       
        produitDao.deleteProduit(prod);
        Produit deletedProd = produitDao.getProduitByRef(ref);
        if(deletedProd==null)
        	 logger.info("==>nouveau produit finalement supprime.");
        Assert.assertNull(deletedProd);
        
	}

}
