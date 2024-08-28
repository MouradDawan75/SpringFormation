package fr.dawan.backrestapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import fr.dawan.backrestapi.entities.Product;
import fr.dawan.backrestapi.entities.Product.ProductState;
import fr.dawan.backrestapi.repositories.ProductRepository;

@SpringBootApplication
public class BackrestapiApplication {
	
	

	public static void main(String[] args) {
		
		SpringApplication.run(BackrestapiApplication.class, args);
	}
	
	
	//On demande à Spring d'instancier la classe RestTemplate au démarrage de l'application
	/*
	 * Bean: mot utilisé par Spring pour désigner un objet instancier par Spring Boot au démarrage de l'application
	 */
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
