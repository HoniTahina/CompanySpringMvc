package com.groupeisi.companyspringmvc.service;

import com.groupeisi.companyspringmvc.dao.IProductDao;
import com.groupeisi.companyspringmvc.dao.ProductDao;
import com.groupeisi.companyspringmvc.dto.ProductDto;
import com.groupeisi.companyspringmvc.entity.ProductEntity;
import com.groupeisi.companyspringmvc.mapper.ProductMapper;

import java.util.List;
import java.util.Optional;

public class ProductService implements IProductService{
	
	private IProductDao productDao = new ProductDao();

	public void setProductDao(IProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public Optional<List<ProductDto>> findAll() {
		List<ProductEntity> productEntityList = productDao.list(new ProductEntity());
		
		return Optional.of(ProductMapper.toListProductDto(productEntityList));
	}

	@Override
	public boolean save(ProductDto productDto) {
		return productDao.save(ProductMapper.toProductEntity(productDto));
	}

	@Override
	public ProductDto getByid(String id, ProductEntity product) {
		return ProductMapper.toProductDto(productDao.get(id, product));
	}

	@Override
	public boolean update(ProductDto productDto) {
		return productDao.update(ProductMapper.toProductEntity(productDto));
	}

}
