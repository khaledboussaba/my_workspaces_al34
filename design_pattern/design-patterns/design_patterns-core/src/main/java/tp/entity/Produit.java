package tp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//NB: les annotations JPA peuvent être ignorées
// par d'autres technologies (JDBC direct , ...)

@Entity
@Table(name="T_Produit")
public class Produit {
	
	@Id
	@Column(name="ref")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long reference;
	
	@Column(name="designation")
	private String label;
	
	@Column(name="prix_ht")
	private Double prix;
	
	
	public Produit()	{
		super();
	}
	
	
	public Produit(Long reference, String label, Double prix) {
		super();
		this.reference = reference;
		this.label = label;
		this.prix = prix;
	}



	public Long getReference() {
		return reference;
	}
	public void setReference(Long reference) {
		this.reference = reference;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}


	@Override
	public String toString() {
		return this.reference+","+this.label+","+this.prix;
	}
	
	
	

}
