package fr.afcepf.al34.ws.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.afcepf.al34.ws.dto.LoginRequest;
import fr.afcepf.al34.ws.dto.LoginResponse;

@RestController
@RequestMapping(value = "/devise-api/public/login", headers = "Accept=application/json")
public class LoginRestCtrl {

	// verifier Username & Password et retourner "message" + "token" + ...
	
	// url comlete: http://localhost:8080/springBootWsApp/devise-api/public/login
	// en entrée : { "username" : "user1", "password" : "pwd1" }
	// en retour { "message" : "...", "token" ; "...", ...}
	@PostMapping("")
	ResponseEntity<LoginResponse> postLogin(@RequestBody LoginRequest loginRequest) {
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setUsername(loginRequest.getUsername());
		if (loginRequest.getUsername().equals("user1") && loginRequest.getPassword().equals("pwd1")) {
			loginResponse.setStatut(true);
			loginResponse.setMessage("successful Login");
			loginResponse.setToken("jeton_ qui_va_bien");
		} else {
			loginResponse.setStatut(false);
			loginResponse.setMessage("Login failed");
			return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK);
	}
	
}
