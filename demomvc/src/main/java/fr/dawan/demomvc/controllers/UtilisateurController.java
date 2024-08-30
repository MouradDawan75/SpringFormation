package fr.dawan.demomvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fr.dawan.demomvc.entities.Utilisateur;
import fr.dawan.demomvc.formbeans.UserForm;
import fr.dawan.demomvc.services.IUtilisateurService;

@Controller
@RequestMapping("utilisateurs")
public class UtilisateurController {
	
	@Autowired
	private IUtilisateurService utilisateurService;
	
	@GetMapping("/display")
	public String display(Model model) throws Exception {
		
		List<Utilisateur> utilisateurs = utilisateurService.getAll();
		model.addAttribute("users", utilisateurs);
		model.addAttribute("userForm", new UserForm());
		
		return "utilisateurs";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id) {
		
		return null;
	}
	
//	@GetMapping("/update/{id}")
//	public String update(@PathVariable("id") long id) {
//		
//		return null;
//	}
	
	@PostMapping("/findByEmail")
	public String findByEmail(@RequestParam("email") String email) {
		
		return null;
		
	}
	
	@PostMapping("/addUtilisateur")
	public String addUser(@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("file") MultipartFile file) throws Exception {
		
		Utilisateur u = new Utilisateur(email, password, false, file.getBytes());
		
		utilisateurService.create(u);
		
		return "login";
		
	}


}
