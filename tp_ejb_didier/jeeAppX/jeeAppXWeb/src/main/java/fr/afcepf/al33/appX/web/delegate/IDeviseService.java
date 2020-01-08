package fr.afcepf.al33.appX.web.delegate;

import java.util.List;

import fr.afcepf.al33.appX.dto.DeviseDto;

public interface IDeviseService {

	DeviseDto getDeviseByCode(String code);
	List<DeviseDto> getAllDevises();
	DeviseDto postDevise(DeviseDto devise);
	void deleteDevise(String code);
	
}
