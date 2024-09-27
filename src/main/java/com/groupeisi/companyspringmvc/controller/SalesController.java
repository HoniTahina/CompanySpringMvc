package com.groupeisi.companyspringmvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.groupeisi.companyspringmvc.dto.ProductDto;
import com.groupeisi.companyspringmvc.dto.SalesDto;
import com.groupeisi.companyspringmvc.service.IProductService;
import com.groupeisi.companyspringmvc.service.ISalesService;
import com.groupeisi.companyspringmvc.service.ProductService;
import com.groupeisi.companyspringmvc.service.SalesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class SalesController {
    private static final Logger logger = LoggerFactory.getLogger(SalesController.class);

    private final ISalesService salesService = new SalesService();
    private final IProductService productService = new ProductService();

    @GetMapping("/sales")
    public String showSales(Model model) {
        logger.info("SalesController - showSales");

        try {
            Optional<List<SalesDto>> sales = salesService.findAll();
            Optional<List<ProductDto>> products = productService.findAll();

            if (sales.isPresent()) {
                model.addAttribute("salesList", sales.get());
            } else {
                model.addAttribute("salesList", new ArrayList<SalesDto>());
            }

            if (products.isPresent()) {
                model.addAttribute("productList", products.get());
            } else {
                model.addAttribute("productList", new ArrayList<ProductDto>());
            }
        } catch (Exception e) {
            logger.error("Erreur lors de la récupération de la liste des ventes", e);
        }

        return "sale/sales";
    }

    @PostMapping("/sales")
    public String saveSale(
            @RequestParam("productRef") String productRef,
            @RequestParam("quantity") double quantity) {
        logger.info("SalesController - saveSale");

        logger.debug("Paramètres reçus : productRef={}, quantity={}", productRef, quantity);
        Optional<ProductDto> productOptional = productService.findByRef(productRef);
        ProductDto productDto = productOptional.get();
        SalesDto salesDto = new SalesDto();
        salesDto.setQuantity(quantity);
       // productDto.setStock(productDto.getStock()-quantity);

        try {
            Optional<ProductDto> product = productService.findByRef(productRef);
            if (product.isPresent()) {
                salesDto.setProduct(product.get());
                //productService.update(productDto);
                salesService.save(salesDto);
                logger.info("Vente enregistrée avec succès");
            } else {
                logger.error("Produit non trouvé avec la référence : {}", productRef);
            }
        } catch (Exception e) {
            logger.error("Erreur lors de l'enregistrement de la vente", e);
        }

        return "redirect:/sales";
    }
}

