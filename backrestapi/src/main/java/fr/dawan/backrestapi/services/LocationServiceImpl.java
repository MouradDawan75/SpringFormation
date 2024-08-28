package fr.dawan.backrestapi.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.dawan.backrestapi.dtos.LocationDto;

@Service
public class LocationServiceImpl implements ILocationService{
	
	@Autowired
	private RestTemplate restTemplate;
	
	private String uri = "https://dawan.org/public/location";

	

	@Override
	public List<LocationDto> importFromOtherSystem() throws Exception {
		/*
		 * getForEntity: renvoie le ResponseEntoyt (le status + le contenu du body)
		 * getForObject: renvoie uniquement le contenu du body
		 * exchange: exécute toutes les méthodes de http: get,post,put,delete
		 */
		
		//LocationDto[] tab = restTemplate.getForObject(uri, LocationDto[].class);
		
		ResponseEntity<LocationDto[]> responseEntity = restTemplate.getForEntity(uri, LocationDto[].class);
		if(responseEntity.getStatusCode() == HttpStatus.OK && responseEntity.hasBody()) {
			LocationDto[] locations = responseEntity.getBody();		
			
			
			return Arrays.asList(locations);
		}
		
		return null;
	}

}
