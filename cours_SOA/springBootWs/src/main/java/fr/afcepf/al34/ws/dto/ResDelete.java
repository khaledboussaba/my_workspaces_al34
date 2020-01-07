package fr.afcepf.al34.ws.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
// { "message": "bien supprimé" ou "deja supprimé ou inexistant" }
public class ResDelete {
	
	private String message;
	//...

	public ResDelete(String message) {
		super();
		this.message = message;
	}

}
