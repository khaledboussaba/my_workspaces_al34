package tp.ioc;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Enumeration;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/*
 * MyXmlBeanFactory : 
 * 
 *   initIocConfigFromXmlFile(String fileName)
 *         analyse/parse un fichier de configuration XML
 *         et charge la configuration IOC en mémoire au format MyIocConfig
 *         
 *   getBean(String beanId) créer et retourne toute une chaine de composants
 *                          reliés entre par injections de dépendances     
 */
public class MyXmlBeanFactory {
	
	private static Logger logger = LoggerFactory.getLogger(MyXmlBeanFactory.class);

	
	private MyIocConfig myIocConfig = new MyIocConfig();
	
	private static MyXmlBeanFactory uniqueInstance = null;
	
	public synchronized static MyXmlBeanFactory getInstance()
	{
		if(uniqueInstance==null)
		{
			uniqueInstance=new MyXmlBeanFactory();
		}
		return uniqueInstance;
	}
	
	private MyXmlBeanFactory()
	{
		super();
	}
	
	// fonction utilitaire bien pratique:
	/*
	public static String getTextOfElement(Node elementNode)
	{
	StringBuffer buf = new StringBuffer();
	NodeList listeNoeudFils = elementNode.getChildNodes();
	for(int i=0;i<listeNoeudFils.getLength();i++)
			 {
			 Node childNode = listeNoeudFils.item(i);
			 if(childNode.getNodeType()==Node.TEXT_NODE)
				buf.append(childNode.getNodeValue());
			 }	
	return buf.toString();	
	}*/

	
	public void initIocConfigFromXmlFile(String fileName)
	{
		DocumentBuilderFactory DocBuilderFactory = DocumentBuilderFactory.newInstance();	
	    
		DocBuilderFactory.setNamespaceAware(false);
	    DocBuilderFactory.setValidating(false);
		
		try {
			/* Fabriquer un parseur DOM: */
			DocumentBuilder docBuilder = DocBuilderFactory.newDocumentBuilder();
			
			/* Declencher le parsing et recuperer une reference sur l'arbre DOM: */
			InputStream inStream = MyXmlBeanFactory.class.getResourceAsStream("../../"+fileName);
			Document xmlDoc = docBuilder.parse(inStream);
					
			Element docElement = xmlDoc.getDocumentElement();
				
			NodeList listeNoeudFils = docElement.getChildNodes();
			if(listeNoeudFils!=null)
			   for(int i=0;i<listeNoeudFils.getLength();i++)
			     {
			     Node childNode = listeNoeudFils.item(i);
			     if(childNode.getNodeType()==Node.ELEMENT_NODE)
			        {
			        if(childNode.getNodeName().equals("bean"))
			             recupererBeanConfig((Element)childNode); // sous fonction        		        	
			        }		
			     }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void recupererBeanConfig(Element beanElt)
	{
	String idBean = beanElt.getAttribute("id");
	MyIocBeanConf iocBeanConf = new MyIocBeanConf();
	iocBeanConf.setIdBean(idBean);
	iocBeanConf.setImplClass( beanElt.getAttribute("class"));
	
	this.myIocConfig.addBeanConf(idBean, iocBeanConf);
	
	NodeList listeNoeudFils = beanElt.getChildNodes();
	if(listeNoeudFils!=null)
	{  
	   for(int i=0;i<listeNoeudFils.getLength();i++)
	     {
	     Node childNode = listeNoeudFils.item(i);
	     if(childNode.getNodeType()==Node.ELEMENT_NODE)
	        {
	        if(childNode.getNodeName().equals("property"))
	        	 recupererPropertyConfig((Element)childNode,iocBeanConf); // sous fonction     
	        }		
	     }
	}	
	}
	
	void recupererPropertyConfig(Element propElt,MyIocBeanConf iocBeanConf)
	{
	String name = propElt.getAttribute("name");
	String value = propElt.getAttribute("value");
	String ref = propElt.getAttribute("ref");
	if(value!=null && value.length()>0) iocBeanConf.getStringProps().setProperty(name, value);
	else if(ref!=null && ref.length()>0) iocBeanConf.getRefProps().setProperty(name, ref);

	}

	
	public static String firstUpper(String chaine)
	{
		String chRes = String.valueOf(chaine.charAt(0)).toUpperCase();
		chRes += chaine.substring(1);
		return chRes;
	}
	
	public Object getBean(String beanId)
	{
		Object objRes=null;
		try {
			MyIocBeanConf beanConf = this.myIocConfig.getBeanConf(beanId);
			 logger.debug("id=" + beanConf.getIdBean() + ",implClass=" + beanConf.getImplClass());
			Class implClass = Class.forName(beanConf.getImplClass());
			objRes = implClass.newInstance();
			
			Enumeration enumRef = beanConf.getRefProps().keys();
			while(enumRef.hasMoreElements())
			{
				String refName= (String) enumRef.nextElement();
				String refBeanId = beanConf.getRefProps().getProperty(refName);
				logger.debug("ref:" + refName +"-" + refBeanId);
				//appel recursif ==> cr�ation des objets n�cessaires en arri�re plan:
				Object depObj = this.getBean(refBeanId); 
				//injection de la d�pendance:
				int i,index=-1; 
				Method[] tabMeth = implClass.getMethods();
				
				for(i=0;i<tabMeth.length;i++)
					if(tabMeth[i].getName().equals("set"+firstUpper(refName)))
						{ index=i; break; }
				if(index>0)
				   tabMeth[index].invoke(objRes, depObj);
			}
			
			Enumeration enumStr = beanConf.getStringProps().keys();
			while(enumStr.hasMoreElements())
			{
				String propName= (String) enumStr.nextElement();
				String propValue = beanConf.getStringProps().getProperty(propName);
				logger.debug("prop:" + propName +"-" + propValue);
				//mise a jour de la propriete:
				int i,index=-1; 
				Method[] tabMeth = implClass.getMethods();
				
				for(i=0;i<tabMeth.length;i++)
					if(tabMeth[i].getName().equals("set"+firstUpper(propName)))
						{ index=i; break; }
				if(index>0)
				   tabMeth[index].invoke(objRes, propValue);
			}
			
		} catch (Exception e) {
		    logger.error("MyXmlBeanFactory.getBean:",e);
			//e.printStackTrace();
		}
		return objRes;
	}

}
