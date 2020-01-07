package fr.afcepf.al34.ws.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "devise")
@Getter @Setter @NoArgsConstructor @ToString
public class Devise {

	@Id
	private String code; // "EUR", "USD", "JPY", "GBP"
	private String name; // "euro", "dollar", "yen", "livre"
	@Column(name = "d_change")
	private Double change; // nb ... pour un dollar
	
	@OneToMany(mappedBy = "devise")
	@JsonIgnore
	List<Pays> pays;
	
	public Devise(String code, String name, Double change) {
		super();
		this.code = code;
		this.name = name;
		this.change = change;
	}
	
}
