package fr.afcepf.al34.authentication;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class AuthenticationManager {

	private static final int SALT_LENGTH = 6;
	private static final int MIN_SALT_CHAR_INDEX = '0'; //33
	private static final int MAX_SALT_CHAR_INDEX = 'z'; //127
	private static Random random = new Random();

	private static String createSalt() {
		String salt = "";
		for (int i = 0; i < SALT_LENGTH; i++) {
			int nb = random.nextInt(MAX_SALT_CHAR_INDEX - MIN_SALT_CHAR_INDEX) + MIN_SALT_CHAR_INDEX;
			salt += (char)nb;
		}
		return salt;
	}

	public static void initializeCredentials(String clearPassword, Credentials credentials) throws Exception {
		
		//je genere un salt
		String salt = createSalt();
		
		//j'ajoute le salt au mot de passe
		String saltedPassword = clearPassword + salt;
		
		//je hashe le mot de passe salé
		String hashedPassword = generateHash(saltedPassword);
		
		//je remplis le nouveau credentials
		credentials.setSalt(salt);
		credentials.setHashedPassword(hashedPassword);
		System.out.println("Salt generated : " + credentials.getSalt());
		System.out.println("ClearPassword after adding salt : " + saltedPassword);
		System.out.println("Hash generated : " + credentials.getHashedPassword());
        
	}
	
	private static String generateHash(String source) throws Exception {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] bytes = md.digest((source).getBytes(StandardCharsets.UTF_8));			
			// bytes to hexadecimal
			StringBuilder sb = new StringBuilder();
			for (byte b : bytes) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("Echec de hashage du mot de passe !!!", e); //le "e" sur cette ligne indique le caused by de l'exception
		} 
		
	}
	
	public static boolean authenticate(String clearPassword, Credentials credentials) throws Exception {
		
		String hashedPassword = generateHash(clearPassword + credentials.getSalt());
		
		return hashedPassword.equals(credentials.getHashedPassword());
	}
	
}
