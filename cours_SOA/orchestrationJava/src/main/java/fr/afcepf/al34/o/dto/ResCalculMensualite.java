package fr.afcepf.al34.o.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString()
public class ResCalculMensualite {

	private Double montant;
	private Integer nbMois ;
	private Double tauxAnnuelPct ;
	private Double mensualite;
	
}
