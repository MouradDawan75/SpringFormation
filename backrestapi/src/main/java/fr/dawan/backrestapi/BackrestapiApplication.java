package fr.dawan.backrestapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.dawan.backrestapi.entities.Product;
import fr.dawan.backrestapi.entities.Product.ProductState;
import fr.dawan.backrestapi.repositories.ProductRepository;

@SpringBootApplication
public class BackrestapiApplication {
	
	

	public static void main(String[] args) {
		
		SpringApplication.run(BackrestapiApplication.class, args);
	}

}
