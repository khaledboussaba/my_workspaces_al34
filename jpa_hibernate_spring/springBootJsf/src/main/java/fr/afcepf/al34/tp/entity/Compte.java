package fr.afcepf.al34.tp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name="compte")
public class Compte implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero_compte")
	private Long numeroCompte;                             
	private String label;
	private Double solde;

	@ManyToOne
	@JoinColumn(name="num_client") //nom de la colonne clef etrangère qui va référencer un client dans la table Compte
	@JsonIgnore
	private Client client;

	public Compte(String label, Double solde) {
		this.label = label;
		this.solde = solde;
	}
	

	@Override
	public String toString() {
		return "Compte [numero=" + numeroCompte + ", label=" + label + ", solde=" + solde + "]";
	}

}