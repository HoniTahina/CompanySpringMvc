package com.groupeisi.companyspringmvc.mapper;

import com.groupeisi.companyspringmvc.dto.PurchasesDto;
import com.groupeisi.companyspringmvc.entities.Purchases;

import java.util.List;
import java.util.stream.Collectors;

public class PurchasesMapper {
    private PurchasesMapper() {
    }

    public static Purchases toPurchasesEntity(PurchasesDto purchasesDto) {

        Purchases purchasesEntity = new Purchases();

        purchasesEntity.setId(purchasesDto.getId());
        purchasesEntity.setDateP(purchasesDto.getDateP());
        purchasesEntity.setQuantity(purchasesDto.getQuantity());
        purchasesEntity.setProduct(ProductMapper.toProductEntity(purchasesDto.getProduct()));

        return purchasesEntity;
    }

    public static PurchasesDto toPurchasesDto(Purchases purchasesEntity) {

        PurchasesDto purchasesDto = new PurchasesDto();

        purchasesDto.setId(purchasesEntity.getId());
        purchasesDto.setDateP(purchasesEntity.getDateP());
        purchasesDto.setQuantity(purchasesEntity.getQuantity());
        purchasesDto.setProduct(ProductMapper.toProductDto(purchasesEntity.getProduct()));

        return purchasesDto;
    }

    public static List<PurchasesDto> toListPurchasesDto(List<Purchases> purchasesEntities) {
        return purchasesEntities.stream()
                .map(PurchasesMapper::toPurchasesDto)
                .collect(Collectors.toList());
    }
}
