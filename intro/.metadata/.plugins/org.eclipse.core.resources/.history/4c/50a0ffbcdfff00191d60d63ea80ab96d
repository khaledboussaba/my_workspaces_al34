package fr.afcepf.al34.authentication;

public class Credentials {
	
	private String login;
	private String hashedPassword;
	private String salt;
	
	
	public Credentials() {
	}

	public Credentials(String login) {
		setLogin(login);
	}
	
	public Credentials(String login, String hashedPassword, String salt) {
		this(login); //appelle le premier constructeur 
		setHashedPassword(hashedPassword);
		setSalt(salt);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}
