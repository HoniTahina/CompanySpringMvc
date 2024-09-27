package com.groupeisi.companyspringmvc.service;

import com.groupeisi.companyspringmvc.dto.SalesDto;

import java.util.List;
import java.util.Optional;

public interface ISalesService {
    Optional<List<SalesDto>> findAll();

    boolean save(SalesDto salesDto);
}
