package com.groupeisi.companyspringmvc.service;

import com.groupeisi.companyspringmvc.dto.ProductDto;
import com.groupeisi.companyspringmvc.entity.ProductEntity;

import java.util.List;
import java.util.Optional;


public interface IProductService {

	Optional<List<ProductDto>> findAll();
	
	boolean save(ProductDto productDto);
	
	ProductDto getByid(String id, ProductEntity product);
	
	boolean update(ProductDto productDto);

}
