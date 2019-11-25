package fr.al34.xml.tp;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import fr.al34.xml.tp.data.Produit;

public class AnalyserXmlViaJAXB {
	
	public static void main(String[] args) {
		analyserFichierXml("src/main/resources/produit.xml");
	}

	private static void analyserFichierXml(String fileName) {
		try {
			JAXBContext jctx = JAXBContext.newInstance(Produit.class);
			Unmarshaller um = jctx.createUnmarshaller();
			//pour remonter des objets en mémoire // suite à la lecture d'un flux xml
			//Marshaller m = jctx.createMarshaller(); // pouor écrire
			Produit p = (Produit) um.unmarshal(new File(fileName));
			System.out.println(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
