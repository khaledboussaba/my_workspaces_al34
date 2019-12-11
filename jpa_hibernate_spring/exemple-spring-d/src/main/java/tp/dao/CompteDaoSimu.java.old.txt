package tp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import tp.entity.Compte;

//CompteDaoSimu : version de simulation sans base
//pour premiers Tps spring (injection de dépendance)

//@Component
//@Repository //@Repository hérite de @Component (pour les DAO)
public class CompteDaoSimu implements CompteDao {

	@Override
	public Compte save(Compte cpt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compte> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte findById(Long num) {
		//simple simulation:
		Compte c  = new Compte();
		c.setNumero(num);
		c.setLabel("compte "+num);
		c.setSolde(150.0);
		return c;
	}

	@Override
	public void deleteById(Long num) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Compte> findByClientNumero(long numClient) {
		// TODO Auto-generated method stub
		return null;
	}

}
