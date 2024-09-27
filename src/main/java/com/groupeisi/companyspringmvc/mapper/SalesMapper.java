package com.groupeisi.companyspringmvc.mapper;

import com.groupeisi.companyspringmvc.dto.SalesDto;
import com.groupeisi.companyspringmvc.entities.Sales;

import java.util.List;
import java.util.stream.Collectors;

public class SalesMapper {

    private SalesMapper() {
    }

    public static Sales toSalesEntity(SalesDto salesDto) {
        Sales sales = new Sales();
        sales.setId(salesDto.getId());
        sales.setDateP(salesDto.getDateP());
        sales.setQuantity(salesDto.getQuantity());
        sales.setProduct(ProductMapper.toProductEntity(salesDto.getProduct()));
        return sales;
    }

    public static SalesDto toSalesDto(Sales sales) {
        SalesDto salesDto = new SalesDto();
        salesDto.setId(sales.getId());
        salesDto.setDateP(sales.getDateP());
        salesDto.setQuantity(sales.getQuantity());
        salesDto.setProduct(ProductMapper.toProductDto(sales.getProduct()));
        return salesDto;
    }

    public static List<SalesDto> toListSalesDto(List<Sales> salesList) {
        return salesList.stream()
                .map(SalesMapper::toSalesDto)
                .collect(Collectors.toList());
    }
}
