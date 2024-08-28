package fr.dawan.backrestapi.services;

import java.util.List;

import fr.dawan.backrestapi.dtos.CategoryDto;

public class CategoryServiceFichier implements ICategoryService{

	@Override
	public List<CategoryDto> getAllBy(int page, int size, String search) throws Exception {
		//Lecture/écriture dans un fichier
		return null;
	}

	@Override
	public CategoryDto saveOrUpdate(CategoryDto dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deteteById(long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CategoryDto getById(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
