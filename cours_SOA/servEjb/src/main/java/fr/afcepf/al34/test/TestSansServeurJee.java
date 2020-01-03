package fr.afcepf.al34.test;

import javax.xml.ws.Endpoint;

import fr.afcepf.al34.serveur.CalculTvaImpl;

public class TestSansServeurJee {

	public static void main(String[] args) {

		System.out.println("Starting Server");
		CalculTvaImpl implementor = new CalculTvaImpl();
		String address ="http://localhost:8181/servSoap/CalculTvaImpl";
		Endpoint.publish(address, implementor);
		
		System.out.println("http://localhost:8181/servSoap/CalculTvaImpl?wsdl");
		
	}

}
