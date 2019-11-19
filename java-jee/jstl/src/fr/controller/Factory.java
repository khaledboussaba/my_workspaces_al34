package fr.controller;

import java.util.HashMap;
import java.util.Map;

public class Factory {

	Map<String, String> factory = new HashMap<String, String>();
	
	static Factory me = null;
	
	public static Factory getInstance() {
		if (me == null) {
			me = new Factory();
		}
		return me;
	}
	
	private Factory() {
		// normalement : remplir la map à partir d'un fichier xml
		// ici on remplit la map à la main
		factory.put("/index.jsp", "fr.controller.ActionIndex");
		factory.put("/deSaisie.toto", "fr.controller.ActionSaisie");
		factory.put("/deAffiche.toto", "fr.controller.ActionAffiche");
	}
	
	public Action getAction(String provenance) {
		String nomAction = factory.get(provenance);
		Action a = null;
		try {
			Class<?> c = Class.forName(nomAction); // crée une classe à partir d'une string
			a = (Action) c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
}
