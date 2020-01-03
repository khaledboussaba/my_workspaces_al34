package fr.afcepf.al34.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import fr.afcepf.al34.ws.service.ICalculTva;

public class SoapClientApp {

	public static void main(String[] args) {
		// appeler un WS Soap codé en java (dans le même langage)
		// on peut se passer de wsimport
		// NB: ce code ne fonctionne que si l'interface ICalculTva comporte l'annotation @WebService

		QName SERVICE_NAME = new QName("http://service.ws.al34.afcepf.fr/", "CalculTvaImplService");
		QName PORT_NAME = new QName("http://service.ws.al34.afcepf.fr/", "CalculTvaImplPort");
		// en précisant une URL WSDL connue et accessible
		String wdlUrl = "http://localhost:8080/springBootWsApp/service/calculTva?wsdl";
		URL wsdlDocumentLocation=null;
		try {wsdlDocumentLocation = new URL(wdlUrl);
		} catch (MalformedURLException e) { 
			e.printStackTrace();
		}
		//avec import javax.xml.ws.Service;
		Service service = Service.create(wsdlDocumentLocation, SERVICE_NAME);
		ICalculTva caculateurWSProxy = (ICalculTva) service.getPort(PORT_NAME, ICalculTva.class);
		double prixTtc = caculateurWSProxy.ttc(100.0, 10.0);
		System.out.println("ttc=" + prixTtc); 

	}

}
