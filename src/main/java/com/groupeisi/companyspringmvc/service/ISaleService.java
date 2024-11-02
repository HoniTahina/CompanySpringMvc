package com.groupeisi.companyspringmvc.service;

import com.groupeisi.companyspringmvc.dto.SaleDto;

import java.util.List;
import java.util.Optional;

public interface ISaleService {

	Optional<List<SaleDto>> findAll();
	
	boolean save(SaleDto saleDto);
}
