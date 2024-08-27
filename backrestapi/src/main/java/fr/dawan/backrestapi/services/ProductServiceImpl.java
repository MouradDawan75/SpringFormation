package fr.dawan.backrestapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import fr.dawan.backrestapi.dtos.ProductDto;
import fr.dawan.backrestapi.entities.Category;
import fr.dawan.backrestapi.entities.Product;
import fr.dawan.backrestapi.repositories.CategoryRepository;
import fr.dawan.backrestapi.repositories.ProductRepository;
import fr.dawan.backrestapi.tools.DtoTool;

/*
 * @Service est une extension de @Component: demande à Spring d'instancier cette, car les méthodes de cette dernière sont
 * d'instance.
 * 
 * Service: couche métier: contient les règles métier -> répond aux besoins des utilisateurs finaux
 * 
 */

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<ProductDto> getAllBy(int page, int size, String search) throws Exception {

		List<ProductDto> result = new ArrayList();

		/*
		 * ObjectMapper: convertir un objet en String et vice versa 
		 * ModelMapper: convertir un dto en entity et vice versa. Ajoutez dans le pom.xml ModelMapper 
		 * <groupId>org.modelmapper</groupId> 
		 * <artifactId>modelmapper</artifactId>
		 * <version>3.1.1</version> 
		 * 
		 * Vérifiez que les attributs sont du mm type et possèdent le mm nom dans le DTO et l'Entity 
		 * pour que le mapping automatique fonctionne avec ModelMapper
		 * 
		 * Doc: https://www.baeldung.com/java-modelmapper
		 */

		List<Product> entities = productRepository.findByDescriptionContaining(search, PageRequest.of(page, size))
				.getContent();
		
		for(Product p : entities) {
			result.add( DtoTool.convert(p, ProductDto.class));
		}

		return result;
	}

	@Override
	public ProductDto saveOrUpdate(ProductDto productDto) throws Exception {
		
		//Gestion des règles métier
//		if(productRepository.findAll().size() < 1000) {
//			//insertion du produit en BD
//		}else {
//			throw new Exception("La quatité est limitée à 1000 produits....");
//		}
		
		Product prod = DtoTool.convert(productDto, Product.class);
		
		//Gestion du ManyToOne avec Category
		Category cat = categoryRepository.findById(productDto.getCategoryId()).get();
		prod.setCategory(cat);
		
		//saveAndFlush: gère l'ajout et la modif
		/*
		 * si id = 0 -> c'est un ajout
		 * si id != 0 -> c'est update
		 */
		Product insertedProduct = productRepository.saveAndFlush(prod);
		
		return DtoTool.convert(insertedProduct, ProductDto.class);
	}

	@Override
	public void deleteByid(long id) throws Exception {
		productRepository.deleteById(id);

	}

	@Override
	public ProductDto getById(long id) throws Exception {
		
		 Optional<Product> optional = productRepository.findById(id);
		 
		 if(optional.isPresent()) {
			 Product p = optional.get();
			 return DtoTool.convert(p, ProductDto.class);
		 }
		
		return null;
	}

}
