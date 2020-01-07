package fr.afcepf.al34.ws.cli.service;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import fr.afcepf.al34.ws.cli.dto.DeviseDto;

public class DeviseServiceDelegate implements IDeviseService {
	
	private RestTemplate restTemplate = new RestTemplate();
	private final String BASE_URL = "http://localhost:8080/springBootWsApp/devise-api/public/devise";

	@Override
	public DeviseDto getDeviseByCode(String code) {
		String url = BASE_URL + "/" + code;
		return restTemplate.getForObject(url, DeviseDto.class);
	}

	@Override
	public List<DeviseDto> getAllDevises() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeviseDto postDevise(DeviseDto devise) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDevise(String code) {
		// TODO Auto-generated method stub

	}

}
