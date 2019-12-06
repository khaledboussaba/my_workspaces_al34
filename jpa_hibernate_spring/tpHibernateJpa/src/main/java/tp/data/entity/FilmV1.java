package tp.data.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//V1 : relation n-n sans infos supplementaire dans table de jointure

@Entity
@Table(name="Film")
public class FilmV1 extends Film {
	
	private List<ActeurV1> acteurs;
	
	@Column(name="dateSortie")
	public Date getDate() {
		return super.getDate();
	}
	
	
	@Override
	public String getProducteur() {
		return super.getProducteur();
	}


	@Override
	public String getTitre() {
		return super.getTitre();
	}



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getIdFilm() {
		return super.getIdFilm();
	}

	@ManyToMany(/*mappedBy="films"*/)
	@JoinTable(name="ActeurFilmV1",   
			   joinColumns={@JoinColumn(name="idFilm")},
			   inverseJoinColumns={@JoinColumn(name="idActeur")})
	public List<ActeurV1> getActeurs() {
		return acteurs;
	}

	public void setActeurs(List<ActeurV1> acteurs) {
		this.acteurs = acteurs;
	}
	
	public void addActeur(ActeurV1 a){
		if(acteurs==null)
			acteurs = new ArrayList<ActeurV1>();
		acteurs.add(a); 
	}
	
	public void removeActeur(ActeurV1 a){
		if(acteurs!=null)
			acteurs.remove(a);
	}
	
    public void removeAllActeur(){
		if(acteurs!=null){
			acteurs.clear();
		}
	}
	

}
