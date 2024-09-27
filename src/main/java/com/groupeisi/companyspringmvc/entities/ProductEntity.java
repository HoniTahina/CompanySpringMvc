package com.groupeisi.companyspringmvc.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "products")
public class ProductEntity implements Serializable {
    @Id
    @Column(name = "ref", nullable = false, unique = true)
    private String ref;

    @Column(name = "name")
    private String name;

    @Column()
    private double stock;

    @OneToMany(mappedBy = "product")
    private List<Purchases> purchases;

    @OneToMany(mappedBy = "product")
    private List<Sales> sales;

    public ProductEntity() {
    }

    public ProductEntity(String ref, String name, double stock, List<Purchases> purchases, List<Sales> sales) {
        this.ref = ref;
        this.name = name;
        this.stock = stock;
        this.purchases = purchases;
        this.sales = sales;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
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

    public List<Purchases> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchases> purchases) {
        this.purchases = purchases;
    }

    public List<Sales> getSales() {
        return sales;
    }

    public void setSales(List<Sales> sales) {
        this.sales = sales;
    }
}
