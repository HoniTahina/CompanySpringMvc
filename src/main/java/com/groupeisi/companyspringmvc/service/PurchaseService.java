package com.groupeisi.companyspringmvc.service;

import com.groupeisi.companyspringmvc.dao.IPurchaseDao;
import com.groupeisi.companyspringmvc.dao.PurchaseDao;
import com.groupeisi.companyspringmvc.dto.PurchaseDto;
import com.groupeisi.companyspringmvc.entity.PurchaseEntity;
import com.groupeisi.companyspringmvc.mapper.PurchaseMapper;

import java.util.List;
import java.util.Optional;

public class PurchaseService implements IPurchaseService{

	private IPurchaseDao purchaseDao = new PurchaseDao();

	public void setPurchaseDao(IPurchaseDao purchaseDao) {
		this.purchaseDao = purchaseDao;
	}
	
	@Override
	public Optional<List<PurchaseDto>> findAll() {
		List<PurchaseEntity> purchaseEntityList = purchaseDao.list(new PurchaseEntity());
		
		return Optional.of(PurchaseMapper.toListPurchaseDto(purchaseEntityList));
	}

	@Override
	public boolean save(PurchaseDto purchaseDto) {
		return purchaseDao.save(PurchaseMapper.toPurchaseEntity(purchaseDto));
	}

}
