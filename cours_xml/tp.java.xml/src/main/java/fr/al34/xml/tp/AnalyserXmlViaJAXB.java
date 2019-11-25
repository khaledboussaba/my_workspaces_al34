package fr.al34.xml.tp;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.al34.xml.tp.data.Commande;
import fr.al34.xml.tp.data.Produit;

public class AnalyserXmlViaJAXB {
	
	public static void main(String[] args) {
		analyserFichierXml("src/main/resources/produit.xml");
		analyserCommandeFichierXml("src/main/resources/commande.xml");
	}

	private static void analyserFichierXml(String fileName) {
		try {
			JAXBContext jctx = JAXBContext.newInstance(Produit.class);
			Unmarshaller um = jctx.createUnmarshaller();
			//pour remonter des objets en mémoire // suite à la lecture d'un flux xml
			//Marshaller m = jctx.createMarshaller(); // pouor écrire
			Produit p = (Produit) um.unmarshal(new File(fileName));
			System.out.println(p);
			
			Marshaller m = jctx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // pour le bon format du fichier xml
			p.setLabel(p.getLabel().toUpperCase()); // modif en mémoire
			m.marshal(p, new File("src/main/resources/produit3.xml")); // ecriture dans un nouveau fichier
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void analyserCommandeFichierXml(String fileName) {
		try {
			JAXBContext jctx = JAXBContext.newInstance(Commande.class);
			Unmarshaller um = jctx.createUnmarshaller();
			Commande c = (Commande) um.unmarshal(new File(fileName));
			System.out.println(c);
			
			// ecrire la commande c dans un fichier json
			ObjectMapper mapper = new ObjectMapper(); // de jackson
			mapper.writeValue(new File("src/main/resources/commande.json"), c);
			
			Marshaller m = jctx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			c.setAdresse(c.getAdresse().toUpperCase());
			m.marshal(c, new File("src/main/resources/commande2.xml"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
