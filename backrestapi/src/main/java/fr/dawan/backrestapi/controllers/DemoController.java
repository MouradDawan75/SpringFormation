package fr.dawan.backrestapi.controllers;

import java.util.Optional;

import javax.security.sasl.AuthenticationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Controller // Controller MVC: qui renvoie une vue au client
@RestController // Controller API: renvoie généralement du contenu JSON
@RequestMapping("/demo")
public class DemoController {
	
	/*
	 * Controller REST: doit fournir des ressources - ends points (URI) + Méthodes d'accès aux ressources
	 */
	
	private static Logger myLogger = LoggerFactory.getLogger(DemoController.class);
	
	//@RequestMapping(method = RequestMethod.GET, value = "/demo/m1")
	@GetMapping(value = "/m1", produces = "text/plain")
	public String m1() {
		
		myLogger.info("Appel de la méthode m1........");
		
		return "m1";
	}
	
	//@RequestMapping(method = RequestMethod.GET, value = "/demo/m2")
	@GetMapping(value = "/m2", produces = "text/plain")
	public String m2() {
		return "m2";
	}
	
	//Pour fournir la max d'infos au poste client, on peut utiliser le type générique ResponseEntity en retour des méthode
	
	@GetMapping(value = "/m3", produces = "text/plain")
	public ResponseEntity<String> m3(){
		
		//Syntaxe 1:
		//return ResponseEntity.ok("m3");
		
		//Syntaxe 2: plus lisible 
		return ResponseEntity.status(HttpStatus.OK).body("m3");
		
	}
	
	//Paramètres obligatoires:
	
	@GetMapping(value = "/m4/{param}")
	public ResponseEntity<String> m4(@PathVariable(value = "param") String p){
		
		return ResponseEntity.status(HttpStatus.OK).body("m4 "+p);
		
	}
	
	//Paramétres optionnels: multi URI
	
	@GetMapping(value = {"/m5/{param}", "/m5"})
	public ResponseEntity<String> m5(@PathVariable(value = "param", required = false)  Optional<String> opt){
		
		if(opt.isEmpty()){
			return ResponseEntity.status(HttpStatus.OK).body("m5");
		}else {
			String contenu = opt.get();
			return ResponseEntity.status(HttpStatus.OK).body("m5 "+contenu);
		}
		
	}
	
	//Request param - paramètres nommés dans la requête: localhost:8085/demo/m6?password=dawan -> le param s'affiche dans l'uri
	//syntaxe non recommandée dans la pratique
	
	@GetMapping(value = "/m6")
	public ResponseEntity<String> m6(@RequestParam(value = "password") String pass){
		return ResponseEntity.status(HttpStatus.OK).body(pass);
		
	}
	
	//Request Body: params fournis dans le Body de la requête
	
	@GetMapping(value = "/m7", consumes = "text/plain", produces = "text/plain")
	public ResponseEntity<String> m7(@RequestBody String message){
		
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
	
	//Gestion des exception
	
	@GetMapping(value = "/exception")
	public String testException() throws AuthenticationException {
		throw new AuthenticationException("Echec connexion......");
		//throw new Exception("Echec connexion......");
	}
	
	@GetMapping(value = "/runtimeException")
	public String testNullException() throws RuntimeException {
		throw new RuntimeException("......");
		//throw new Exception("Echec connexion......");
	}
	
	/*
	 * Pour gérer les exceptions:
	 * Option1:
	 * Gestion des exception au niveau du controller: 
	 * si une méthode de ce controller génère une exception, la méthode exceptionHandler() est exécutée
	 */
	
//	@ExceptionHandler(Exception.class)
//	public String exceptionHandler() {
//		return "erreur........";
//	}
	
	/*
	 * Option2: 
	 * Gestion des exception au niveau global (pour tous les controllers)
	 * Créer une classe (intercepteur) avec l'annotation @ControllerAdvice, qui hérité du HandlerException
	 */
	
	
	

}
