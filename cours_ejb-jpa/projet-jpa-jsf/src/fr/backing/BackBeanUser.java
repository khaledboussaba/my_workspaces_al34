package fr.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import fr.entity.User;

@Named
@SessionScoped
public class BackBeanUser implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private User user;
	
	List<User> users = new ArrayList<User>();

	public String connectUser() {
		// TODO
		return null;
	}
	
	public String addUser() {
		// TODO
		System.out.println("nouveau user ajouté : " + user.getLogin());
		//users.add(user);
		return "/signup.xhtml";
	}
	
	public String displayUsers() {
		for (User user : users) {
			System.out.println(user.getLogin());
		}
		return "/displayUsers.xhtml";
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
