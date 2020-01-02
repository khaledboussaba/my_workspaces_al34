package fr.afcepf.al34.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import fr.afcepf.al34.dto.ResCalculTva;
import fr.afcepf.al34.itf.ICalculTva;

public class CliAjbApp {

	public static void main(String[] args) {

		try {
			String machineServeur = "localhost"; //ou 192.168.xx.YY

			Properties props = new Properties();
			// context et initialisation de javax.naming
			props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
			props.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
//			props.put(Context.PROVIDER_URL, "remote+http://localhost:8080");
			
			// remote://localhost:4447 for Jboss7.1 , http-remoting://localhost:8080 for wildfly 8,9
			props.put(Context.SECURITY_PRINCIPAL, "guest"); // username : "admin" , "guest" , "..."
			props.put(Context.SECURITY_CREDENTIALS, "guest007"); //password : "pwd", "guest007"
			//avec utilisateur ajouté via la commande JBOSS_7_HOME/bin/add-user
			//et roles associés admin,guest,.... sur partie "ApplicationRealm" .
			props.put("jboss.naming.client.ejb.context", true); //indispensable pour accès @Remote
			Context jndiContext = new InitialContext(props);

			String nomLogiqueCalculateur = "ejb:servEjb/CalculTvaImpl!fr.afcepf.al34.itf.ICalculTva";
			ICalculTva proxyCalculateurTva = (ICalculTva) jndiContext.lookup(nomLogiqueCalculateur);

			double tva = proxyCalculateurTva.tva(200.0, 20.0);
			System.out.println("tva = " + tva);

			String auteur = proxyCalculateurTva.getAuteur();
			System.out.println("auteur = " + auteur);

			ResCalculTva resCalculTva = proxyCalculateurTva.tvaEtTtc(200.0, 20.0);
			System.out.println("résultat ttc = " + resCalculTva.getTtc());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}




