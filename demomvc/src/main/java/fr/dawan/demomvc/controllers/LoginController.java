package fr.dawan.demomvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fr.dawan.demomvc.services.IUtilisateurService;

@Controller
public class LoginController {
	
	private IUtilisateurService utilisateurService;
	
	@GetMapping("/login")
	public String display() {
		return "login";
	}
	
	@GetMapping("/create-account")
	public String createAccount() {
		
		return "create-account";
	}
	
	@PostMapping("/authentification")
	public String authentification() {
		
		
		return null;
	}

}
