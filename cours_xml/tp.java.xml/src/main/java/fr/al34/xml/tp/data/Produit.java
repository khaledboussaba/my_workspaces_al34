package fr.al34.xml.tp.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * l'api JAXB2 est utilisée en interne par l'api JAX-WS (Web Service SOAP) 
 */

/*
 *annotation de JAXB2 (package "javax.xml..bind..." et @Xml...()
 *JAXB2 est intégré dans la JVM à partir de Java 6  
 */
@XmlRootElement(name = "produit", namespace = Produit.PROD_NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD) // pour demander à analyser les @Xml...() au dessus des FIELDS
public class Produit {
	
	public static final String PROD_NAMESPACE = "http://www.example.org/produit";
	
	@XmlAttribute(name = "ref")
	private String ref;
	@XmlElement(name = "label", namespace = PROD_NAMESPACE)
	private String label;
	@XmlElement(name = "prix", namespace = PROD_NAMESPACE)
	private double prix;
		
	public Produit() {
	}
	public Produit(String ref, String label, double prix) {
		this.ref = ref;
		this.label = label;
		this.prix = prix;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getLabel() {
		return label;
	}
	public void setLabal(String label) {
		this.label = label;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "Produit [ref=" + ref + ", label=" + label + ", prix=" + prix + "]";
	}	

}
