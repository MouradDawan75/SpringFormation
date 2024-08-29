package fr.dawan.demomvc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.dawan.demomvc.entities.Produit;
import fr.dawan.demomvc.services.IProduitService;

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
	
	@Autowired
	private IProduitService produitService;

	
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String Accueil(Model model) throws Exception{
		
		//Le controller utilise le model pour fournir des données à la vue
		
		model.addAttribute("message", "Page d'accueil depuis le Controller new");
		
		Player player = new Player("Patrice");
		
		model.addAttribute("player", player);
		
		List<Player> players = new ArrayList<>();
		players.add(new Player("Jean"));
		players.add(new Player("Marie"));
		
		model.addAttribute("allPlayer", players);
		
		
		
		return "index";
	}
	
	@GetMapping("/load")
	public String loadTestData() throws Exception {
		
		//Vérifier si la table est vide:
		
		if(produitService.getAll().size() == 0) {
			
			Produit p1 = new Produit("PC Dell", 1500, 10);
			produitService.create(p1);
			
			Produit p2 = new Produit("Ecran HP", 99, 10);
			produitService.create(p2);
			
			Produit p3 = new Produit("Table", 30, 10);
			produitService.create(p3);
		}
		
		return "redirect:/";
	}
}
