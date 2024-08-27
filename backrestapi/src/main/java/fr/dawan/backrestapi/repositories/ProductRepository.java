package fr.dawan.backrestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dawan.backrestapi.entities.Product;

/*
 * Repositories de Spring Data
 */
// @Repository: demande à Spring Boot d'instancier ProductRepository au démarrage de l'application
// Annontation qui n'est pas nécessaire car déjà utilisée dans JpaRepository


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	/*
	 * On peut ajouter des méthodes personalisées:
	 * 1- En utilisant les commandes JP-QL
	 * 2- En utilisant les finders méthodes de Spring Data
	 * Doc de Spring Data Finders Methods: https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
	 */

}
