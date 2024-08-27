package fr.dawan.backrestapi.tools;

import org.modelmapper.ModelMapper;


public class DtoTool {
	
	private static ModelMapper mapper = new ModelMapper();
	
//	public static ProductDto fromProduct(Product p) {
//		ProductDto dto = new ProductDto();
//		dto.setId(p.getId());
//		dto.setDescription(p.getDescription());
//		dto.setPrice(p.getPrice());
//		dto.setImagePath(p.getImagePath());
//		dto.setCategoryId(p.getCategory().getId());
//		
//		return dto;
//	}
	
	public static <TSource, TDestination> TDestination convert(TSource source, Class<TDestination> clazz){
		return mapper.map(source, clazz);
	}

}
