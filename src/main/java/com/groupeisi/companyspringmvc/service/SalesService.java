package com.groupeisi.companyspringmvc.service;

import java.util.List;
import java.util.Optional;

import com.groupeisi.companyspringmvc.dao.ISalesDao;
import com.groupeisi.companyspringmvc.dao.SalesDao;
import com.groupeisi.companyspringmvc.dto.ProductDto;
import com.groupeisi.companyspringmvc.dto.SalesDto;
import com.groupeisi.companyspringmvc.entities.Sales;
import com.groupeisi.companyspringmvc.mapper.SalesMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class SalesService implements ISalesService {

    private static final Logger logger = LoggerFactory.getLogger(PurchasesService.class);
    private ISalesDao salesDao = new SalesDao();
    private IProductService productService = new ProductService();

    @Override
    public Optional<List<SalesDto>> findAll() {
        List<Sales> salesEntities = salesDao.list(new Sales());
        List<SalesDto> salesDtos = SalesMapper.toListSalesDto(salesEntities);

        return Optional.of(salesDtos);
    }

    @Override
    public boolean save(SalesDto salesDto) {

        logger.info("SalesService - Tentative d'enregistrement d'une vente : {}", salesDto);

        Sales salesEntity = SalesMapper.toSalesEntity(salesDto);
        ProductDto productDto = salesDto.getProduct();

        try {

            double newStockValue = productDto.getStock() - salesDto.getQuantity();

            productDto.setStock(newStockValue);

            boolean productUpdated = productService.update(productDto);
            logger.info("SalesService - Mise à jour du produit réussie : {}", productUpdated);

            if (!productUpdated) {
                logger.warn("PurchasesService - Échec de la mise à jour du stock pour le produit avec ref : {}", productDto.getRef());
                return false;
            }

            boolean salesSaved = salesDao.save(salesEntity);
            logger.info("SalesService - Enregistrement de la vente réussie : {}", salesSaved);

            return salesSaved;
        } catch (Exception e) {
            logger.error("SalesService - Erreur lors de l'enregistrement de la vente", e);
            return false;
        }
    }

}
