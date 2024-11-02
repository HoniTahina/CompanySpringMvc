package com.groupeisi.companyspringmvc.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "sales")
public class SaleEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "date", length = 200, nullable = false)
	private Date date;
	
	@Column(name = "quantity", nullable = false)
	private double quantity;

	@ManyToOne
	private ProductEntity product;

	public SaleEntity(Date date, double quantity, ProductEntity product) {
		super();
		this.date = date;
		this.quantity = quantity;
		this.product = product;
	}

	public SaleEntity() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	
}
