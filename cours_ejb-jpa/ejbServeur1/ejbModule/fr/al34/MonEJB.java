package fr.al34;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class MonEJB
 */
@Stateless
@LocalBean
public class MonEJB implements MonEJBRemote, MonEJBLocal {

    public MonEJB() {
    }

	@Override
	public String sayHello() {
		return "Hello, it's me !!!";
	}

}
