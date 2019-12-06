package tp.persistence.spring.dao;

import tp.data.entity.RoleActeurFilm;
import tp.data.entity.RoleActeurFilmCompositePk;

public interface GestionFilmsActeursRoles extends GestionFilmsActeurs {
	
	 // CRUD - RoleActeurFilm
	//public RoleActeurFilm getRoleActeurFilmByPk(long idActeur,long idFilm);
	//public Collection<RoleActeurFilm> getRoleActeurFilmByXY(...);
	
	public RoleActeurFilmCompositePk createRoleActeurFilm(RoleActeurFilm roleActeurFilm);// return pk
	public void updateRoleActeurFilm(RoleActeurFilm roleActeurFilm);
	public void deleteRoleActeurFilm(long idActeur,long idFilm);
	

}
