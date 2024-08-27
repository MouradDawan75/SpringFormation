package fr.dawan.backrestapi.services;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import fr.dawan.backrestapi.dtos.ProductDto;

@Service
public class FileService {
	
	@Value("${storage.folder}")
	private String storageFolder;
	
	public Resource getResource(ProductDto dto) throws Exception {
		
		//Paths.get("."): permet de revenir à la racine de disque dur contenant le projet (c: pour ce projet)
		
				Path newPath = Paths.get(".").resolve(storageFolder+dto.getImagePath());
				Resource resource = new UrlResource(newPath.toUri());
				return resource;
	}

}
