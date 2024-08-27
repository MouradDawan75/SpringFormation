package fr.dawan.backrestapi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import fr.dawan.backrestapi.entities.Category;
import fr.dawan.backrestapi.entities.Product;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	Page<Category> findByNameContaining(String name, Pageable pageable);
}
