package fr.afcepf.al34.ws.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.afcepf.al34.ws.dto.ResDelete;
import fr.afcepf.al34.ws.service.DeviseService;

@RestController
@RequestMapping(value = "/devise-api/private/devise", headers = "Accept=application/json")
public class DeviseRestPrivateCtrl {

	@Autowired
	private DeviseService deviseService;

	// mode DELETE: http://localhost:8080/springBootWsApp/devise-api/private/devise/JPY
	// a tester avec le logiciel PostMan ou un equivalent
	@DeleteMapping(value = "/{codeDevise}")
	public ResponseEntity<ResDelete> deleteDeviseByCode(@PathVariable("codeDevise") String code) {
		try {
			deviseService.supprimerDevise(code);
			return new ResponseEntity<ResDelete>(new ResDelete("suppression bien effectuée"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ResDelete>(new ResDelete("devise déja supprimée ou inexistante"), HttpStatus.OK);
		}
	}

}
