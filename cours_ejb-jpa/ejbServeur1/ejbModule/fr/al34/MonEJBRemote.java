package fr.al34;

import javax.ejb.Remote;

@Remote
public interface MonEJBRemote {

	public String sayHello();
	
}
