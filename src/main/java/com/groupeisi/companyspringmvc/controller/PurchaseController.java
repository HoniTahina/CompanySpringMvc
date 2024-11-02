package com.groupeisi.companyspringmvc.controller;

import com.groupeisi.companyspringmvc.dto.ProductDto;
import com.groupeisi.companyspringmvc.dto.PurchaseDto;
import com.groupeisi.companyspringmvc.entity.ProductEntity;
import com.groupeisi.companyspringmvc.service.IProductService;
import com.groupeisi.companyspringmvc.service.IPurchaseService;
import com.groupeisi.companyspringmvc.service.ProductService;
import com.groupeisi.companyspringmvc.service.PurchaseService;
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
public class PurchaseController {

    private static final Logger logger = LoggerFactory.getLogger(PurchaseController.class);

    private final IPurchaseService purchasesService = new PurchaseService();
    private final IProductService productService = new ProductService();

    @GetMapping("/purchases")
    public String findAll(Model model) {

        try {
            Optional<List<PurchaseDto>> purchases = purchasesService.findAll();
            model.addAttribute("purchasesList", purchases.orElse(new ArrayList<>()));

            Optional<List<ProductDto>> products = productService.findAll();
            model.addAttribute("productList", products.orElse(new ArrayList<>()));
        } catch (Exception e) {
            logger.error("Erreur lors de la récupération des données", e);
        }

        return "purchase/purchase";
    }

    @PostMapping("/purchases")
    public String save(
            @RequestParam("reference") String productRef,
            @RequestParam("quantity") String quantity) {

        double qte = Double.parseDouble(quantity);

        ProductEntity productEntity = new ProductEntity();
        ProductDto product = productService.getByid(productRef, productEntity);
        product.setStock(product.getStock() + qte);

        if (product != null) {
            PurchaseDto purchaseDto = new PurchaseDto(new Date(), qte, product);

            try {
                purchasesService.save(purchaseDto);
                productService.update(product);
            } catch (Exception e) {
                logger.error("Erreur d'enregistrement de l'achat", e);
            }
        } else {
            logger.error("Produit non trouvé avec la référence ");
        }

        return "redirect:/purchases";
    }

}
