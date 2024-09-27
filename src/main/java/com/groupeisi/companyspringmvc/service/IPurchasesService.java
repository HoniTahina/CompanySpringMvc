package com.groupeisi.companyspringmvc.service;

import com.groupeisi.companyspringmvc.dto.PurchasesDto;

import java.util.List;
import java.util.Optional;


public interface IPurchasesService {

    Optional<List<PurchasesDto>> findAll();

    boolean save(PurchasesDto purchasesDto);

}
