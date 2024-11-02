package com.groupeisi.companyspringmvc.mapper;

import com.groupeisi.companyspringmvc.dto.ProductDto;
import com.groupeisi.companyspringmvc.entity.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

	private ProductMapper() {
		
	}

	public static ProductEntity toProductEntity(ProductDto ProductDto) {
		
		ProductEntity ProductEntity = new ProductEntity();
		
		ProductEntity.setReference(ProductDto.getReference());
		ProductEntity.setName(ProductDto.getName());
		ProductEntity.setStock(ProductDto.getStock());
		
		return ProductEntity;	
	}
	
	public static ProductDto toProductDto(ProductEntity ProductEntity) {
		
		ProductDto ProductDto = new ProductDto();
		
		ProductDto.setName(ProductEntity.getName());
		ProductDto.setReference(ProductEntity.getReference());
		ProductDto.setStock(ProductEntity.getStock());
		
		return ProductDto;	
	}
	
	public static List<ProductDto> toListProductDto(List<ProductEntity> ProductEntities) {
		return ProductEntities.stream()
							.map(ProductMapper::toProductDto)
							.collect(Collectors.toList());
	}	
	
	public static List<ProductEntity> toListProductEntity(List<ProductDto> ProductDtos) {
		return ProductDtos.stream()
							.map(ProductMapper::toProductEntity)
							.collect(Collectors.toList());
	}	
}
