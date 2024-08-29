package fr.dawan.demomvc.controllers;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dawan.demomvc.entities.Produit;
import fr.dawan.demomvc.formbeans.ProduitForm;
import fr.dawan.demomvc.services.IProduitService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("produits")
public class ProduitController {
	
	@Autowired
	private IProduitService produitService;
	
	@GetMapping("/display")
	public String display(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size) throws Exception{
		
		 displayPaging(model, page, size);
		 
		 model.addAttribute("produitForm", new ProduitForm());
		 
		 return "produits";
		
	}

	private void displayPaging(Model model, int page, int size) throws Exception {
		
		List<Produit> totalProduits = produitService.getAll();
		 
		 //totalProduits.stream().filter(p -> p.getPrice() > 100).collect(Collectors.toList()).forEach(p -> System.out.println(p));
		 
		 int totalIems = totalProduits.size();
		 int totalPages = 0;
		 
		 
		 
		 if(totalIems % size == 0) {
			 totalPages = totalIems / size;
		 }else {
			 totalPages = totalIems / size + 1;
		 }
		 
		 model.addAttribute("produits", produitService.getAllPaging(page, size));
		 
		 
		 
		 model.addAttribute("size", size);
		 
		 if(totalPages > 0) {
			 
			 //Construire une liste de int allant de 1 à totalPages
			 List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
					 						.boxed()
					 						.collect(Collectors.toList());
			 model.addAttribute("pageNumbers", pageNumbers);
		 }
	}
	
	//@ModelAttribute: permet de gérer les objets connectés aux formulaires
	
	@PostMapping("/addProduit")
	public String addProduit(@Valid @ModelAttribute("produitForm") ProduitForm produitForm, BindingResult bindingResult, Model model) throws Exception {
		
		//bindingResult: contient les erreurs de validation
		
		if(bindingResult.hasErrors()) {
			
			System.out.println(">>>>>>>>>> Formulaire non valide...........");
			
			displayPaging(model, 1, 3);
			
			//Ne pas renvoyer un ProduitForm
			// model.addAttribute("produitForm", new ProduitForm()); - car il écrase celui fourni par le formulaire
			
			return "produits";
		}
		
		Produit produit = new Produit(produitForm.getId(), produitForm.getDescription(), produitForm.getPrice(), produitForm.getQuantite());
		
		if(produit.getId() == 0) {
		produitService.create(produit);
		}else {
			produitService.update(produit);
		}
		
		return "redirect:/produits/display";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id) throws Exception {
		produitService.deleteById(id);
		return "redirect:/produits/display";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable("id") long id, Model model) throws Exception {
		
		Produit prod = produitService.getById(id);
		//prod à afficher dans le formulaire -> à convertir en ProduitForm
		
		ProduitForm prodForm = new ProduitForm(prod.getId(), prod.getDescription(), prod.getPrice(), prod.getQuantite());
		
		model.addAttribute("produitForm", prodForm);
		model.addAttribute("produits", produitService.getAll());
		
		return "produits";
	}
	
	@PostMapping("/findByKey")
	public String findByKey(@RequestParam("motCle") String key, Model model)  throws Exception{
		
		List<Produit> prods = produitService.findByDescription(key);
		
		model.addAttribute("produits", prods);
		model.addAttribute("produitForm", new ProduitForm());
		
		return "produits";
	}
	
	@GetMapping("/moins/{id}")
	public String quantiteMoins(@PathVariable("id") long id) throws Exception{
		
		Produit prod = produitService.getById(id);
		if(prod.getQuantite() > 1) {
			prod.setQuantite(prod.getQuantite() - 1);
			produitService.update(prod);
		}
		
		return "redirect:/produits/display";
	}
	
	@GetMapping("/plus/{id}")
	public String quantitePlus(@PathVariable("id") long id) throws Exception{
		
		Produit prod = produitService.getById(id);
		prod.setQuantite(prod.getQuantite() + 1);
		produitService.update(prod);
		
		return "redirect:/produits/display";
	}

}
