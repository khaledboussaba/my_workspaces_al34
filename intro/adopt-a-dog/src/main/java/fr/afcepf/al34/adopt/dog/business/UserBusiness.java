package fr.afcepf.al34.adopt.dog.business;

import fr.afcepf.al34.adopt.dog.entities.User;
import fr.afcepf.al34.authenticator.AuthenticationManager;
import fr.afcepf.al34.authenticator.Credentials;
import fr.afcepf.al34.authenticator.exceptions.AuthenticationException;

public class UserBusiness {

	
	public void connect(String login, String clearPassword) {
		User user = new User();
		user.setLogin(login);
		user.setHashPassword(clearPassword);
		
		Credentials credentials = new Credentials(login);
		credentials.setLogin(login);
		
		//AuthenticationManager.authenticate(clearPassword, credentials);
		
		
		
		try {
			AuthenticationManager.initializeCredentials(clearPassword, credentials);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		
		
		//AuthenticationManager.authenticate(login, clearPassword);
	}
	
	public void createAccount() {
		
	}
}