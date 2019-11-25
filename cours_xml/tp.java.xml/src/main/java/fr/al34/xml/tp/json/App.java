package fr.al34.xml.tp.json;

import java.util.ArrayList;
import java.util.Collection;

import fr.al34.xml.tp.data.Commande;
import fr.al34.xml.tp.data.Produit;

public class App {
	
	public static void main(String[] args) {
		
		LowLevelJsonUtil.demoSimpleJsonJava();
		System.out.println("*******************************");
		JacksonJsonUtil.demoJsonJavaViaJacksonObjectMapper();
		System.out.println("*******************************");
		/*
		 * en javascript:
		 * var stringJson = JSON.stringify(objetJS);
		 * var objJS = JSON.parse(jsonString)
		 */
		
		Produit p1 = new Produit("refP1", "cahier", 12.5);
		String p1AsJsontString = JacksonJsonUtil.stringify(p1);
		System.out.println(p1AsJsontString);
		System.out.println("*******************************");
		
		String p2AsJsonString = "{'ref':'p2' , 'label':'cahier' , 'prix':2.3 }".replace('\'', '\"');
		Produit p2 = (Produit) JacksonJsonUtil.parse(p2AsJsonString, Produit.class);
		System.out.println(p2);
		//NB: chaine json volontairement sans prix et avec comment n'existant pas dan la classe Produit
		//c'est ignoré grace au bloc static de la classe JacksonJsonUtil
		String p3AsJsonString = "{'ref':'p2' , 'label':'cahier' , 'comment':'ok' }".replace('\'', '\"');
		Produit p3 = (Produit) JacksonJsonUtil.parse(p3AsJsonString, Produit.class);
		System.out.println(p3);
		System.out.println("*******************************");
		
		
		Collection<Produit> produits = new ArrayList<Produit>();
		produits.add(p1);
		produits.add(p2);
		produits.add(p3);
		Commande commande = new Commande(2, "2019-11-25", "25 rue de la république", produits);
		System.out.println("commande Java : " + commande.toString());
		System.out.println("+++");
		String commandeAsJsontString = JacksonJsonUtil.stringify(commande); // a tester avec ou sans JsonIgnore au dessus de produits dans Commande.java
		System.out.println("commande Json : " + commandeAsJsontString);
	}
	
}
