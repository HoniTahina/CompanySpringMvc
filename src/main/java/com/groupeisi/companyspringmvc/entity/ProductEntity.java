package com.groupeisi.companyspringmvc.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @Column(name = "reference", length = 200, nullable = false, unique = true)
    private String reference;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "stock", nullable = false)
    private double stock;

    @OneToMany(mappedBy = "product")
    private List<PurchaseEntity> purchases;

    @OneToMany(mappedBy = "product")
    private List<SaleEntity> sales;

    public ProductEntity() {
        super();
    }

    public ProductEntity(String reference, String string, double stock) {
        super();
        this.reference = reference;
        this.name = string;
        this.stock = stock;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public List<PurchaseEntity> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<PurchaseEntity> purchases) {
        this.purchases = purchases;
    }

    public List<SaleEntity> getSales() {
        return sales;
    }

    public void setSales(List<SaleEntity> sales) {
        this.sales = sales;
    }
}
