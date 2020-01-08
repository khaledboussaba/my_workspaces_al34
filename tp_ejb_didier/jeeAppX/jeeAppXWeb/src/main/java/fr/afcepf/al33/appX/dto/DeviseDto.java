package fr.afcepf.al33.appX.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class DeviseDto {

	private String code;
	private String name; 
	private Double change;
	
	public DeviseDto(String code, String name, Double change) {
		super();
		this.code = code;
		this.name = name;
		this.change = change;
	}
	
}
