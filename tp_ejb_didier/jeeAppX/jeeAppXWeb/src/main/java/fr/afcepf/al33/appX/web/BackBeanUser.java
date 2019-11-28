package fr.afcepf.al33.appX.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import fr.afcepf.al34.appX.entity.User;
import fr.afcepf.al34.appX.service.UserService;

@Named
@SessionScoped
public class BackBeanUser implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EJB
	//ou bien @Inject
	private UserService ejbUserService;
	private List<User> users;
	private User user;
	
	@PostConstruct
	public void init() {
		users = ejbUserService.findAllUsers();
	}
	
	public BackBeanUser() {
		user = new User();
	}

	public String addUser() {
		ejbUserService.createUser(user);
		user = new User();
		init();
		return "/displayUsers.xhtml";
	}
	
	public String deleteUser(User u) {
		ejbUserService.removeUser(u.getId());
		init();
		return "/displayUsers.xhtml";
	}
	
	public String displayUsers() {
		users = ejbUserService.findAllUsers();
		for (User user : users) {
			System.out.println(user.getLogin());
		}
		return "/displayUsers.xhtml";
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
