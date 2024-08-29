package fr.dawan.demomvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.dawan.demomvc.entities.Produit;
import fr.dawan.demomvc.services.IProduitService;

@Controller
@RequestMapping("produits")
public class ProduitController {
	
	@Autowired
	private IProduitService produitService;
	
	@GetMapping("/display")
	public String display(Model model) throws Exception{
		
		 List<Produit> produitListe = produitService.getAll();
		 model.addAttribute("produits", produitListe);
		 
		 model.addAttribute("produit", new Produit());
		 
		 return "produits";
		
	}
	
	//@ModelAttribute: permet de gérer les objets connectés aux formulaires
	
	@PostMapping("/addProduit")
	public String addProduit(@ModelAttribute("produit") Produit produit) throws Exception {
		
		produitService.create(produit);
		
		return "redirect:/produits/display";
	}

}
