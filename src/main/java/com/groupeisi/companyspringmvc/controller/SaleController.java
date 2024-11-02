package com.groupeisi.companyspringmvc.controller;

import com.groupeisi.companyspringmvc.dto.ProductDto;
import com.groupeisi.companyspringmvc.dto.SaleDto;
import com.groupeisi.companyspringmvc.entity.ProductEntity;
import com.groupeisi.companyspringmvc.service.IProductService;
import com.groupeisi.companyspringmvc.service.ISaleService;
import com.groupeisi.companyspringmvc.service.ProductService;
import com.groupeisi.companyspringmvc.service.SaleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class SaleController {

    private static final Logger logger = LoggerFactory.getLogger(SaleController.class);

    private final ISaleService salesService = new SaleService();
    private final IProductService productService = new ProductService();

    @GetMapping("/sales")
    public String showSale(Model model) {

        try {
            Optional<List<SaleDto>> sales = salesService.findAll();
            Optional<List<ProductDto>> products = productService.findAll();

            if (sales.isPresent()) {
                model.addAttribute("salesList", sales.get());
            } else {
                model.addAttribute("salesList", new ArrayList<SaleDto>());
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
            @RequestParam("reference") String productRef,
            @RequestParam("quantity") String quantity) {

        double qte = Double.parseDouble(quantity);


        ProductEntity productEntity = new ProductEntity();
        ProductDto product = productService.getByid(productRef, productEntity);
        product.setStock(product.getStock() - qte);
        SaleDto saleDto = new SaleDto(new Date(), qte, product);

        try {
            if (product != null) {
                salesService.save(saleDto);
                productService.update(product);
            } else {
                logger.error("Produit non trouvé avec la référence : {}", productRef);
            }
        } catch (Exception e) {
            logger.error("Erreur d'enregistrement de la vente", e);
        }

        return "redirect:/sales";
    }
}
