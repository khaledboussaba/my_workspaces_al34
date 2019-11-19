package fr.afcepf.al34.demo.maven;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
	
	private static final Logger logger = LogManager.getLogger();
	
	public static void main(String[] args) {

		logger.debug("Ceci est un message de debug");
		logger.info("Ceci est une info");
		logger.warn("Ceci est une warning");
		logger.error("Ceci est une erreur");
		logger.fatal("Ceci est une erreur fatale !");
		
	}

}
