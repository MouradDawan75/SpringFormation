package fr.dawan.backrestapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.backrestapi.dtos.CategoryDto;
import fr.dawan.backrestapi.services.ICategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryService;
	
	
	@GetMapping(value = {"/{page}/{size}/{search}", "/{page}/{size}"}, produces = "application/json")
	public List<CategoryDto> getAllBy(@PathVariable("page") int page, @PathVariable("size") int size,
			  @PathVariable(value = "search", required = false) Optional<String> searchOpt ) throws Exception{
		
		if(searchOpt.isPresent()) {
			return categoryService.getAllBy(page, size, searchOpt.get());
		}else {
			return categoryService.getAllBy(page, size, "");
		}
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Object> getById(@PathVariable("id") long id) throws Exception{
		
		CategoryDto dto = categoryService.getById(id);
		if(dto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category with id = "+id+" not found.");
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(dto);
		}
		
	}
	
	@DeleteMapping(value = "/{id}", produces = "text/plain")
	public ResponseEntity<String> deleteById(@PathVariable("id") long id) throws Exception{
		
		CategoryDto dto = categoryService.getById(id);
		if(dto != null) {
			categoryService.deteteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Categiry with id = "+id+" deleted.");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category with id = "+id+" not found.");
		}
		
	}
	
	//save or update
	
	@PostMapping(value ="", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CategoryDto> saveOrUpdate(@RequestBody CategoryDto dto) throws Exception{
		
		
		CategoryDto savedDto = categoryService.saveOrUpdate(dto);
		return ResponseEntity.status(HttpStatus.OK).body(savedDto);
		
	}
	/*
	 * Conventions de nommage:
	 * packages: en miniscules
	 * camelCase: addProduct: méthodes + variables
	 * PascalCase: AddProduct - Classes + Interface + Classes Abstraites
	 * snake_case: add_product (convention utilisée par Python)
	 * 
	 */
	

}
