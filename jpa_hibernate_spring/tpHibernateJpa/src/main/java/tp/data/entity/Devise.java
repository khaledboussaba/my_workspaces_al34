
package tp.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
 @Table(name="Devise") //here as annotation or specified/overrided in orm.xml
public  class Devise  {

	@Column(name="dChange") //here as annotation or specified/overrided in orm.xml
	private Double change;
	
	@Column(length=64)
	private String monnaie;
	
	@Column(length=8)
	@Id
	private String codeDevise;

	public Devise(){
		super(); 
	}      
	public String toString(){
		return "Devise("+ "change=" + change+","+ "monnaie=" + monnaie+","+ "codeDevise=" + codeDevise + ")";
	}
 
	public java.io.Serializable getPk(){
	 		return codeDevise;
  	}
	public Double getChange() {
		return this.change;
	}
	public void setChange(Double change){
		this.change=change;
	}
	public String getMonnaie() {
		return this.monnaie;
	}
	public void setMonnaie(String monnaie){
		this.monnaie=monnaie;
	}
	public String getCodeDevise() {
		return this.codeDevise;
	}
	public void setCodeDevise(String codeDevise){
		this.codeDevise=codeDevise;
	}

        
} 
