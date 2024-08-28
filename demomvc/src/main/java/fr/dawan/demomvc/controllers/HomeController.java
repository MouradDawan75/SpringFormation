package fr.dawan.demomvc.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Controller MVC: qui renvoie des pages HTML
/*
 * Template Engine (moteur de vues):
 * Il existe plusieurs moteurs de vue Java: JSP (inclut dans Java EE), FreeMaker, Velocity, Thymeleaf.
 * Spring Boot: pour les applications MVC, utilise Thymeleaf comme moteur de vues par défaut.
 * Dans le pom.xml, ajoutez le starter de Thymeleaf:
 * 
 * Clic droit sur le projet -> Spring -> Add Starters -> choisir Thymeleaf.
 * 
 * Par défaut, les pages html doivent être placées dans le répertoire src/main/resources/templates.
 * Les fichiers statiques (non modifiés par Thymeleaf) doivent être placés dans le répertoires src/main/resources/static
 * (css, js, images........).
 * 
 * Thymeleaf utilise des attributs pour générer du contenu dynamique dans les vues.
 */


class Player{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Player(String name) {
		super();
		this.name = name;
	}

	public Player() {
		super();
	}
	
	
}

@Controller
public class HomeController {

	
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String Accueil(Model model) {
		
		//Le controller utilise le model pour fournir des données à la vue
		
		model.addAttribute("message", "Page d'accueil depuis le Controller new");
		
		Player player = new Player("Patrice");
		
		model.addAttribute("player", player);
		
		return "index";
	}
}
