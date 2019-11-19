package fr.afcepf.al34.authentication.tester;

import fr.afcepf.al34.authentication.AuthenticationManager;
import fr.afcepf.al34.authentication.Credentials;

public class Test {

	public static void main(String[] args) throws Exception {
		Credentials c1 = new Credentials("toto");
		Credentials c2 = new Credentials("jane");
		
		AuthenticationManager.initializeCredentials("soleil", c1);
		System.out.println(AuthenticationManager.authenticate("solel", c1));
		System.out.println(AuthenticationManager.authenticate("soleil", c1));
		System.out.println("______________________________");
		AuthenticationManager.initializeCredentials("lune", c2);
		System.out.println(AuthenticationManager.authenticate("lune", c2));
		System.out.println(AuthenticationManager.authenticate("line", c2));
		
	}
	
}
