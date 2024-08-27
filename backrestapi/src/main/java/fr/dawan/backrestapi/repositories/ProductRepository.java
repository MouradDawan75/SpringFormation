package fr.dawan.backrestapi.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
	Page<Product> findByDescriptionContaining(String description, Pageable pageable);
	
	//ManyTone avec Category - commande JP-QL
	
	@Query(value = "From Product p where p.category.id =: id")
	List<Product> findAllByCategoryId(@Param("id") long id);
	
	//Equivalent en sql natif
	
	@Query(nativeQuery = true, value = "Select * From Product p INNER JOIN Category c ON (p.category_id = c.id) where c.id =: id")
	List<Product> findSqlByCategoryId(@Param("id") long id);
	

}
