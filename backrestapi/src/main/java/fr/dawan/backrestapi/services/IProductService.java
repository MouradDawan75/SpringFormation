package fr.dawan.backrestapi.services;

import java.util.List;

import fr.dawan.backrestapi.dtos.ProductDto;

public interface IProductService {
	
	List<ProductDto> getAllBy(int page, int size, String search) throws Exception;
	ProductDto saveOrUpdate(ProductDto productDto) throws Exception;
	void deleteByid(long id) throws Exception;
	ProductDto getById(long id) throws Exception;

}
