package fr.al34.xml.tp;

import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class AnalyserXml {
	
	static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
	
	public static void main(String[] args) {
		analyserFichierXml("src/main/resources/produit.xml");
	}
	
	public static void analyserFichierXml(String fileName) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			//valider en tenant compte d'un dtd ou xsd
			factory.setNamespaceAware(true);
			factory.setValidating(true);
			factory.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
			
			/* Fabriquer un parseur DOM */
			DocumentBuilder docBuilder = factory.newDocumentBuilder();

			docBuilder.setErrorHandler(new ErrorHandler() {
				
				public void warning(SAXParseException e) throws SAXException {
					System.err.println(e);
				}
				
				public void fatalError(SAXParseException e) throws SAXException {
					System.err.println(e);
					System.exit(0);
				}
				
				public void error(SAXParseException e) throws SAXException {
					System.err.println(e);
					System.err.println("document xml pas valide -- arret du parsing");
					System.exit(0);
				}
			});
			
			/* Déclencher le parsing et récupérer une référence sur l'arbre DOM */
			Document xmlDoc = docBuilder.parse(fileName);
			Element docElement = xmlDoc.getDocumentElement(); //accés à la balise principale
			
			System.out.println("Namespace : " + docElement.getNamespaceURI());
			
			String valeurAttributRf = docElement.getAttribute("ref");
			System.out.println("Valeur attribut ref : " + valeurAttributRf);
			
			NodeList nodeList = docElement.getChildNodes();
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				//attention: Node = noeud quelconque (Comment, Text, Element)
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element elt = (Element) node;
					System.out.println(elt.getNodeName() + " : " + elt.getTextContent());
				}
			}
			
			//accés direct au prix
			String sPrix = docElement.getElementsByTagName("prix").item(0).getTextContent();
			System.out.println("Le prix : " + sPrix);
			
			//ajouter une balise
			Element newElt = xmlDoc.createElement("caracteristique"); // à ratacher
			newElt.appendChild(xmlDoc.createTextNode("bonne qualite"));
			docElement.appendChild(newElt);
			
			//générer un ficher produit2.xml à partir de l'arbre modifié/agrandi
			TransformerFactory trFactory = TransformerFactory.newInstance();
			Transformer tr = trFactory.newTransformer();
			tr.transform(new DOMSource(xmlDoc), new StreamResult(new FileOutputStream("src/main/resources/produit2.xml")));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
