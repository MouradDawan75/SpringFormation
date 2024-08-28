package fr.dawan.backrestapi.services;

import java.util.List;

import fr.dawan.backrestapi.dtos.LocationDto;

public interface ILocationService {
	
	List<LocationDto> importFromOtherSystem() throws Exception;

}
