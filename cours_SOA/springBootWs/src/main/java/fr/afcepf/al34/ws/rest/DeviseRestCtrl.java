package fr.afcepf.al34.ws.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.afcepf.al34.ws.entity.Devise;
import fr.afcepf.al34.ws.service.DeviseService;

@RestController
@RequestMapping(value = "/devise-api/public/devise", headers = "Accept=application/json")
public class DeviseRestCtrl {
	
	@Autowired
	private DeviseService deviseService;
	
	// url comlete: http://localhost:8080/springBootWsApp/devise-api/public/devise/code
	@RequestMapping(value = "/{codeDevise}", method = RequestMethod.GET)
	public Devise getDeviseByCode(@PathVariable("codeDevise") String code) {
		return deviseService.rechercherDeviseParSonCode(code);
	}
	
}
