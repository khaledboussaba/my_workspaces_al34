package fr.entity;

public class Login {

	private String name;
	private String password;
		
	public Login() {
	}

	public Login(String name, String password) {
		setName(name);
		setPassword(password);
	}
	
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final String getPassword() {
		return password;
	}
	public final void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
}
