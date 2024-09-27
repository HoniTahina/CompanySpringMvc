package com.groupeisi.companyspringmvc.dao;

import com.groupeisi.companyspringmvc.entities.ProductEntity;

import java.util.Optional;


public interface IProductDao extends Repository<ProductEntity> {

    Optional<ProductEntity> findByRef(String ref);

    boolean update(ProductEntity productEntity);
}
