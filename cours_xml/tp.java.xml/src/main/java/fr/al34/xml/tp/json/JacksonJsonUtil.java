package fr.al34.xml.tp.json;

import java.io.File;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.al34.xml.tp.data.Produit;


//(com.fasterxml.)jackson.databind in pom.xml is a medium level json api for java

public class JacksonJsonUtil {

	public static ObjectMapper jacksonObjectMapper  = new ObjectMapper();
	
	static {
		jacksonObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	/*
	// classe = Produit.class ou Commande.class
	public static Object parse(String jsonString, Class classe) {
		Object object = null;
		try {
			object = jacksonObjectMapper.readValue(jsonString, classe);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}
	*/
	//simplification de la methode précédente
	public static <T> T parse(String jsonString, Class<T> classe) {
		T object = null;
		try {
			object = jacksonObjectMapper.readValue(jsonString, classe);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}
	
	public static String stringify(Object object) {
		String jsonString = null;
		try {
			jsonString = jacksonObjectMapper.writeValueAsString(object);			
		} catch (Exception e) {
		}
		return jsonString;
	}
	
	public static void demoJsonJavaViaJacksonObjectMapper() {
		System.out.println("demoJsonJavaViaJacksonObjectMapper");
		try {
			
		Produit p1 = new Produit("p1","gomme",2.3);
		System.out.println("p1:"+p1);//p1:Produit [ref=p1, label=gomme, prix=2.3]
		String p1AsJsonString = jacksonObjectMapper.writeValueAsString(p1);
		System.out.println("p1AsJsonString:"+p1AsJsonString);
		//p1AsJsonString:{"ref":"p1","label":"gomme","prix":2.3}
		jacksonObjectMapper.writeValue(new File("src/main/resources/p1.json"), p1);
		
		String p2AsJsonString = "{'ref':'p2' , 'label':'cahier' , 'prix':3.3 }".replace('\'', '\"');
		System.out.println("p2AsJsonString:"+p2AsJsonString);
		//p2AsJsonString:{"ref":"p2" , "label":"cahier" , "prix":3.3 }
		Produit p2 = jacksonObjectMapper.readValue(p2AsJsonString,Produit.class);
		System.out.println("p2:"+p2);//p2:Produit [ref=p2, label=cahier, prix=3.3]	
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
}
