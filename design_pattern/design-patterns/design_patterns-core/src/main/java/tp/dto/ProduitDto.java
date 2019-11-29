package tp.dto;

import java.io.Serializable;
/*
 * DTO = Data Transfert Object
 *     = structures de données remontées par la couche "services métiers"
 *       et quelquefois transférées à travers le réseau (ex: RMI , SOAP , REST, ...)
 *     = structures quelquefois adpatées/différentes des "entités persistantes"
 */
public class ProduitDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String reference;
	private String label;
	private Double prix;
	
	
	public ProduitDto() {
		super();
	}
	public ProduitDto(String reference, String label, Double prix) {
		super();
		this.reference = reference;
		this.label = label;
		this.prix = prix;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	@Override
	public String toString() {
		return "ProduitDto [reference=" + reference + ", label=" + label + ", prix=" + prix + "]";
	}
	
	
	
	

}
