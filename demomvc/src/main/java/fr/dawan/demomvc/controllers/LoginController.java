package fr.dawan.demomvc.controllers;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dawan.demomvc.entities.Utilisateur;
import fr.dawan.demomvc.services.IUtilisateurService;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	private IUtilisateurService utilisateurService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping("/login")
	public String display() {
		return "login";
	}
	
	@GetMapping("/create-account")
	public String createAccount() {
		
		return "create-account";
	}
	
	@PostMapping("/authentification")
	public String authentification(@RequestParam("email") String email, 
			@RequestParam("password") String password, Model model, HttpSession session) throws Exception {
		
		Utilisateur userDb = utilisateurService.findByEmail(email);
		if(userDb != null && encoder.matches(password, userDb.getPassword())) {
			//connexion ok
			
			byte[] encodeBase64 = Base64.getEncoder().encode(userDb.getPhoto());
			String chaine64 = new String(encodeBase64, "UTF-8");
			userDb.setImageBase64(chaine64);
			
			//Tant que l'application est en cours d'exécution, la session est active
			//Les serveur injecte un id de session dans la réponse renvoyée au client.
			//Tous les échanges entre le client et le serveur, à partir du déclenchement du suivie de la session
			//implique la présence de l'id de session.
			
			
			
			session.setAttribute("user", userDb);
			session.setAttribute("email", email);
			session.setAttribute("admin", userDb.isAdmin());
			session.setAttribute("image", userDb.getImageBase64());
			
			return "redirect:/";
			
			
		}else {
			model.addAttribute("erreur", "Echec de la connexion.....");
			return "login";
		}
		
		
		
	}
	
	@GetMapping("/deconnexion")
	public String logout(HttpSession session) {
		
		//Mettre fin au suivi de session
		session.invalidate();
		
		return "login";
	}

}
