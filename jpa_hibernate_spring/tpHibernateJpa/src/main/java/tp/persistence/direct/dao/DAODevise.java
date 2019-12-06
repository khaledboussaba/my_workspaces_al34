package tp.persistence.direct.dao;

import java.util.List;

import tp.data.entity.Devise;
import tp.data.entity.Pays;

public interface DAODevise {
	public void deleteDevise(String codeDevise); // remove entity from pk
	public void removeDevise(Devise dev); // remove entity
	public  Devise updateDevise(Devise dev); // update entity (and return persist ref )
	public  Devise getDeviseByCode(String codeDevise);//by primary key
    public Devise persistNewDevise(Devise dev); // persist entity (and return it with pk )
	
	public Devise getDeviseByName(String deviseName);
	public List<Devise> getAllDevise(); 
	public List<Pays> getListePaysPartageantDevise(String codeDevise); 

}
