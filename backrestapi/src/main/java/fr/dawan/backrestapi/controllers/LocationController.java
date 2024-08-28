package fr.dawan.backrestapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.backrestapi.dtos.LocationDto;
import fr.dawan.backrestapi.services.ILocationService;

@RestController
public class LocationController {
	
	@Autowired
	private ILocationService locationService;
	
	@GetMapping(value = "/api/locations")
	public List<LocationDto> getAllLocation() throws Exception{
		
		return locationService.importFromOtherSystem();
		
	}

}
