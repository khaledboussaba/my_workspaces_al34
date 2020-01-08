package fr.afcepf.al34.ws.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	// url comlete: http://localhost:8080/springBootWsApp/devise-api/public/login
	// en entrée : { "username" : "user1", "password" : "pwd1" }
	// en retour { "message" : "...", "token" ; "...", ...}
	
	/* V1
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
	*/
	
	/* V2 avec Spring Security*/
	@PostMapping("")
	public ResponseEntity<LoginResponse> postLogin(@RequestBody LoginRequest loginRequest){
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setUsername(loginRequest.getUsername());
		
		try {
		Authentication authentication = null;
		//vérifier le username/password avec SpringSecurity:
		authentication = authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(
		                loginRequest.getUsername(),
		                loginRequest.getPassword()
		        ));//authenticate() soulève une exception si mauvais username ou password
			loginResponse.setStatut(true);
			loginResponse.setMessage("successful login");
			loginResponse.setToken("jeton_qui_va_bien");
		}catch(Exception ex) {
			loginResponse.setStatut(false);
			loginResponse.setMessage("login failed");
			return new ResponseEntity<LoginResponse>(loginResponse,HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<LoginResponse>(loginResponse,HttpStatus.OK);
	}
	
	
}
