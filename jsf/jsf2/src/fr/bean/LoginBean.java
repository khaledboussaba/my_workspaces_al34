package fr.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Named
@SessionScoped
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private String login = "ali";
    private String password = "baba";
    @Email
    private String email;
    @Size(min = 3, max = 8)
    private String name;
	
    public String getLogin() {
    	System.out.println("dans getLogin");
		return login;
	}
	public void setLogin(String login) {
		System.out.println("dans setLogin : " + login);
		this.login = login;
	}
	public String getPassword() {
		System.out.println("dans getPassword");
		return password;
	}
	public void setPassword(String password) {
		System.out.println("dans getPassword : " + password);
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String returnAction() {
    	System.out.println("dans returnAction ");
    	return password.equals("baba") ? "success" : "failure";
    }

    public String autreAction() {
    	System.out.println("dans autreAction ");
    	return "pageSuivante";
    }
    
    public void validateAFiel(FacesContext context, UIComponent component, Object value) throws ValidatorException {
    	String inputValue = (String) value;
    	if (! inputValue.contains("a")) {
			FacesMessage msg = new FacesMessage("Mauvais format: doit contenir un 'a'");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
    }
	
}