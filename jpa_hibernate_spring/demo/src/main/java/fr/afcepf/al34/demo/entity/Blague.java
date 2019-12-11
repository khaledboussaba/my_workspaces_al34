package fr.afcepf.al34.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@NamedQuery(name = "Blague.findByGoodNote" , query = "SELECT b FROM Blague b WHERE b.note >= 3")
public class Blague {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titre;
	private String texte;
	
	private Integer note;//null ou de 0 à 5 (0 : nulle , 1 : pas drôle , 5 : très drôle)
	
	

	public Blague(Long id, String titre, String texte) {
		super();
		this.id = id;
		this.titre = titre;
		this.texte = texte;
	}



	@Override
	public String toString() {
		return "Blague [id=" + id + ", titre=" + titre + ", texte=" + texte + ", note=" + note + "]";
	}
	

}
