package fr.dawan.backrestapi.services;

import java.util.List;

import fr.dawan.backrestapi.dtos.CategoryDto;

public interface ICategoryService {
	
	//CRUD: Create - Read - Update - Delete
	
	List<CategoryDto> getAllBy(int page, int size, String search) throws Exception;
	CategoryDto saveOrUpdate(CategoryDto dto) throws Exception;
	void deteteById(long id) throws Exception;
	CategoryDto getById(long id) throws Exception;

}
