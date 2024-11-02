package com.groupeisi.companyspringmvc.dto;

import java.util.Date;

public class PurchaseDto {

	private long id;
	
	private Date date;
	
	private double quantity;
	
    private ProductDto product;

	public PurchaseDto(Date date, double quantity, ProductDto product) {
		super();
		this.date = date;
		this.quantity = quantity;
		this.product = product;
	}

	public PurchaseDto() {
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

	public ProductDto getProduct() {
		return product;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}

}
