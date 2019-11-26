package fr.al34;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class MonDeuxiemEJB
 */
@Stateless
@LocalBean
public class MonDeuxiemEJB implements MonDeuxiemEJBRemote {

    public MonDeuxiemEJB() {
    }

	@Override
	public String sayBy() {
		return "By By !!!";
	}
    
    

}
