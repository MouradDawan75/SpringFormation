package fr.dawan.demomvc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.dawan.demomvc.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>{
	
	List<Produit> findByDescriptionContaining(String name); //finder méthode de Spring Data
	
	
	
	//Equivalent de la méthode précédente avec une commande JPQL
	//@Query(value = "From Produit p where p.description like :key")
	//List<Produit> findByKey(@Param("key") String key); //commande JPQL car Produit ne possède d'attribut key

}
