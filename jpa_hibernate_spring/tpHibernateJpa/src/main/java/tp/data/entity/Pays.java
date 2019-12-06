package tp.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
CREATE TABLE Pays(
		codePays VARCHAR(8),
		capitale VARCHAR(64),
		nomPays VARCHAR(64),
		ref_devise VARCHAR(64),
		PRIMARY KEY(codePays));	 
*/

@Entity
@Table(name="Pays")
public class Pays {
	@Id
	private String codePays;// "fr", "de", ...
	private String nomPays;
	private String capitale;
	
	@ManyToOne
	@JoinColumn(name="ref_devise")
	private Devise devise;
	
	

	@Override
	public String toString() {
		return "Pays [codePays=" + codePays + ", nomPays=" + nomPays + ", capitale=" + capitale + "]";
	}

	public String getCodePays() {
		return codePays;
	}

	public void setCodePays(String codePays) {
		this.codePays = codePays;
	}

	public String getNomPays() {
		return nomPays;
	}

	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}

	public String getCapitale() {
		return capitale;
	}

	public void setCapitale(String capitale) {
		this.capitale = capitale;
	}

	public Devise getDevise() {
		return devise;
	}

	public void setDevise(Devise devise) {
		this.devise = devise;
	}

	
	
}
