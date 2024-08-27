package fr.dawan.backrestapi.controllers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.dawan.backrestapi.dtos.ProductDto;
import fr.dawan.backrestapi.services.IProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Value("${storage.folder}")
	private String storageFolder;
	
	
	@GetMapping(value = {"/{page}/{size}/{search}", "/{page}/{size}"}, produces = "application/json")
	public List<ProductDto> getAllBy(
			@PathVariable("page") int page,
			@PathVariable("size") int size,
			@PathVariable(value = "search", required = false) Optional<String> search) throws Exception
	{
		/*
		 * La pagination dans les méthodes de Jpa Repository commence à 0
		 * http://localhost:8085/api/products/1/5/pc
		 */
		
		if(search.isEmpty()) {
			return productService.getAllBy(page - 1, size, "");
		}else {
			return productService.getAllBy(page - 1, size, search.get());
		}
		
	}
	
	//Add product
	/*
	 * Stream(flux): une sorte de canal intermédiaire entre une source et une destination
	 * 2 types de stream:
	 * flux binaire: lecture/écriture char/char: FileInputStream - FileOutputStream (BufferedIntputStream - BufferedOutputStream)
	 * flux chaine de caractères: lecture ligne/ligne: FileReader - FileWriter
	 */
	
	@PostMapping(value = "", consumes = "multipart/form-data", produces = "application/json")
	public ResponseEntity<ProductDto> saveOrUpdate(@RequestParam("productString") String prodString, 
			@RequestPart("file") MultipartFile file) throws Exception{
		
		//Gestion du productString
		ProductDto dto = objectMapper.readValue(prodString, ProductDto.class);
		
		//Gestion du fichier
		String filePath = "/"+dto.getDescription()+"-"+file.getOriginalFilename(); //personaliser le nom du fichier
		File f = new File(storageFolder+filePath);
		
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f), 16392); //doubler la taille du buffer
		bos.write(file.getBytes());
		
		dto.setImagePath(filePath);
		
		ProductDto insertedDto = productService.saveOrUpdate(dto);
		
		return ResponseEntity.status(HttpStatus.OK).body(insertedDto);
		
		
	}
	
	@DeleteMapping(value = "/{id}", produces = "text/plain")
	public ResponseEntity<String> delete(@PathVariable("id") long id) throws Exception{
		
		ProductDto dto = productService.getById(id);
		if(dto != null) {
			productService.deleteByid(id);
			return ResponseEntity.status(HttpStatus.OK).body("Product with id = "+id+" deleted.");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No product to delete.");
		}
		
	}

}
