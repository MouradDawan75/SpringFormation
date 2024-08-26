package fr.dawan.backrestapi.controllers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.dawan.backrestapi.dtos.ErrorDto;

@RestController
@RequestMapping("/api/logs")
public class LogController {
	/*
	 * Déstiné aux admin de l'api: permet de consulter le fichier des logs
	 * 
	 */

	private static Logger myLogger = LoggerFactory.getLogger(LogController.class);

	@Value("${storage.folder}") // pour récupérer la valeur du param storage.folder définit dans
								// application.properties
	private String storageFolder;

	// ObjectMapper est instanciée par Spring Boot au démarrage de l'application

	@Autowired
	private ObjectMapper objectMapper;

	@GetMapping(value = "/{fileName}", produces = "application/octet-stream")
	public ResponseEntity<Resource> getLogFile(@PathVariable("fileName") String fileName) throws Exception {

		// dans l'uri: http://localhost:8085/api/logs/logback.log (spécifiez l'extension
		// du fichier)

		File f = new File(storageFolder + "/" + fileName);
		ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(Paths.get((f.getAbsolutePath()))));

		// Retourner le résultat
		// Pour afficher une boite de téléchargement dans une réponse http au lieu de
		// charger le contenu du fichier
		// dans le body -
		// dans le header: spécifier ces params: Content-Disposition -
		// attachment;filename=app.log

		myLogger.info("Téléchargement du fichier des logs: " + fileName);

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
		headers.add("Cache-Control", "no-cache, no-store"); // ne pas conserver le fichier dans la cache - param
															// optionnel

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_OCTET_STREAM)
				.contentLength(f.length()).body(resource);

	}

	// Méthode pour insérer un log dans logback.log

	@PostMapping(consumes = "application/json")
	public ResponseEntity<String> postLog(@RequestBody ErrorDto dto) throws JsonProcessingException {

		// convertir le contenu du body (format json) en texte à insérer dans le fichier
		// des logs
		/*
		 * ObjectMapper: convertir json - texte et vice versa - fait partie de la
		 * dépendance Jackson ModelMapper: convertir dto -> en entity (model) et vice
		 * versa
		 */

		String texte = objectMapper.writeValueAsString(dto);

		switch (dto.getErrorLevel()) {
		
		case INFO:

			myLogger.info(texte);
			break;

		case WARNING:

			myLogger.warn(texte);
			break;

		case ERROR:

			myLogger.error(texte);
			break;

		}
		
		return ResponseEntity.status(HttpStatus.OK).body("Message de log inséré.........");

	}
}
