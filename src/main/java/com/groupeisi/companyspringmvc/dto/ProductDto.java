package com.groupeisi.companyspringmvc.dto;

public class ProductDto {

	private String reference;
	private String name;
	private double stock;
	public ProductDto() {
		super();
	}
	public ProductDto(String reference, String string, double stock) {
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
}
