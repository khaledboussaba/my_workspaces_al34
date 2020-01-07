package fr.afcepf.al34.ws.cli.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.afcepf.al34.ws.cli.dto.DeviseDto;

@Service //composant spring de type "business service" (codé localement ou par délégation)
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
		DeviseDto[] tabDevises = null;
		tabDevises = restTemplate.getForObject(BASE_URL, DeviseDto[].class);
		return Arrays.asList(tabDevises);
	}

	@Override
	public DeviseDto postDevise(DeviseDto devise) {
		return restTemplate.postForObject(BASE_URL, devise, DeviseDto.class);
	}

	@Override
	public void deleteDevise(String code) {
		String url = BASE_URL + "/" + code;
		restTemplate.delete(url);
	}

}
