package fr.afcepf.al34.ws.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pays")
@Getter @Setter @NoArgsConstructor
public class Pays {

	@Id
	private String code; // "fr", "de", "it"
	private String name; // "France"
	private String capitale; // "Paris"
	
	@ManyToOne
	@JoinColumn(name = "codeDevise")
	private Devise devise;

	public Pays(String code, String name, String capitale) {
		super();
		this.code = code;
		this.name = name;
		this.capitale = capitale;
	}
	
}
