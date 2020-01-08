package fr.afcepf.al34.ws.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class LoginResponse {

	private String username;
	private Boolean statut; //true or false
	private String message; // authentification reussie ou echec
	private String token; // jwt au autre
	
	public LoginResponse(String username, Boolean statut, String message, String token) {
		super();
		this.username = username;
		this.statut = statut;
		this.message = message;
		this.token = token;
	}

}
