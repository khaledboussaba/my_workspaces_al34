package fr.al34.xml.tp.data;

import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "commande", namespace = Commande.CMDE_NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD) // pour demander à analyser les @Xml...() au dessus des FIELDS
public class Commande {
	
	public static final String CMDE_NAMESPACE = "http://www.example.org/commande";
	
	@XmlAttribute(name = "num")
	private int num;
	@XmlAttribute(name = "date")
	private String date;
	@XmlElement(name = "adresse", namespace = CMDE_NAMESPACE)
	private String adresse;
	@XmlElement(name = "produit", namespace = Produit.PROD_NAMESPACE)
//	@JsonIgnore
	private Collection<Produit> produits;
	
	public Commande() {
	}
	public Commande(int num, String date, String adresse, Collection<Produit> produits) {
		this.num = num;
		this.date = date;
		this.adresse = adresse;
		this.produits = produits;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Collection<Produit> getProduits() {
		return produits;
	}
	public void setProduits(Collection<Produit> produits) {
		this.produits = produits;
	}
	@Override
	public String toString() {
		return "Commande [num=" + num + ", date=" + date + ", adresse=" + adresse + ", produits=" + produits + "]";
	}
	
}