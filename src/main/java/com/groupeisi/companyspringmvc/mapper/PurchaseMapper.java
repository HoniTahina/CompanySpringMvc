package com.groupeisi.companyspringmvc.mapper;

import com.groupeisi.companyspringmvc.dto.PurchaseDto;
import com.groupeisi.companyspringmvc.entity.PurchaseEntity;

import java.util.List;
import java.util.stream.Collectors;


public class PurchaseMapper {

	private PurchaseMapper() {
		
	}

	public static PurchaseEntity toPurchaseEntity(PurchaseDto purchaseDto) {
		
		PurchaseEntity purchaseEntity = new PurchaseEntity();
		
		purchaseEntity.setDate(purchaseDto.getDate());
		purchaseEntity.setQuantity(purchaseDto.getQuantity());
		purchaseEntity.setProduct(ProductMapper.toProductEntity(purchaseDto.getProduct()));
		
		return purchaseEntity;	
	}
	
	public static PurchaseDto toPurchaseDto(PurchaseEntity purchaseEntity) {
		
		PurchaseDto purchaseDto = new PurchaseDto();
		
		purchaseDto.setDate(purchaseEntity.getDate());
		purchaseDto.setId(purchaseEntity.getId());
		purchaseDto.setQuantity(purchaseEntity.getQuantity());
		purchaseDto.setProduct(ProductMapper.toProductDto(purchaseEntity.getProduct()));
		
		return purchaseDto;	
	}
	
	public static List<PurchaseDto> toListPurchaseDto(List<PurchaseEntity> PurchaseEntities) {
		return PurchaseEntities.stream()
							.map(PurchaseMapper::toPurchaseDto)
				.collect(Collectors.toList());
	}	
}
