package com.groupeisi.companyspringmvc.service;

import com.groupeisi.companyspringmvc.dao.ISaleDao;
import com.groupeisi.companyspringmvc.dao.SaleDao;
import com.groupeisi.companyspringmvc.dto.SaleDto;
import com.groupeisi.companyspringmvc.entity.SaleEntity;
import com.groupeisi.companyspringmvc.mapper.SaleMapper;

import java.util.List;
import java.util.Optional;

public class SaleService implements ISaleService {

	private ISaleDao saleDao = new SaleDao();

	public void setSaleDao(ISaleDao saleDao) {
		this.saleDao = saleDao;
	}
	
	@Override
	public Optional<List<SaleDto>> findAll() {
		List<SaleEntity> saleEntityList = saleDao.list(new SaleEntity());
		
		return Optional.of(SaleMapper.toListSaleDto(saleEntityList));
	}

	@Override
	public boolean save(SaleDto saleDto) {
		return saleDao.save(SaleMapper.toSaleEntity(saleDto));
	}

}
