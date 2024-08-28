package fr.dawan.backrestapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.dawan.backrestapi.dtos.CategoryDto;
import fr.dawan.backrestapi.entities.Category;
import fr.dawan.backrestapi.repositories.CategoryRepository;
import fr.dawan.backrestapi.tools.DtoTool;

@Service
public class CategoryServiceImpl implements ICategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<CategoryDto> getAllBy(int page, int size, String search) throws Exception {
	
		List<CategoryDto> result = new ArrayList<>();
		
		List<Category> entities = categoryRepository.findByNameContaining(search, PageRequest.of(page, size)).getContent();
		
		for(Category cat : entities) {
			CategoryDto dto =  DtoTool.convert(cat, CategoryDto.class);
			result.add(dto);
		}
		
		return result;
	}

	@Override
	public CategoryDto saveOrUpdate(CategoryDto dto) throws Exception {
		
		Category entity = DtoTool.convert(dto, Category.class);
		
		/*
		 * Si id de Entity = 0 -> saveAndFlush sauvegarde l'entiy en bd -> exécute la commande sql insert
		 * Si id de Entity != 0 -> saveAndFlush maj l'entiy en bd -> exécute la commande sql update
		 * 
		 */
		Category savedCategory = categoryRepository.saveAndFlush(entity);
		CategoryDto savedDto = DtoTool.convert(savedCategory, CategoryDto.class);
		
		
		
		return savedDto;
	}

	@Override
	public void deteteById(long id) throws Exception {
		
		categoryRepository.deleteById(id);
		
	}

	@Override
	public CategoryDto getById(long id) throws Exception {
	
		Optional<Category> optional = categoryRepository.findById(id);
		
		if(optional.isPresent()) {
			Category cat = optional.get();
			return DtoTool.convert(cat, CategoryDto.class);
		}
		
		return null;
	}

}
