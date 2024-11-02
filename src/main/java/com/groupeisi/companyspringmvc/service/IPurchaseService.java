package com.groupeisi.companyspringmvc.service;

import com.groupeisi.companyspringmvc.dto.PurchaseDto;

import java.util.List;
import java.util.Optional;


public interface IPurchaseService {
	
	Optional<List<PurchaseDto>> findAll();
	
	boolean save(PurchaseDto purchaseDto);

}
