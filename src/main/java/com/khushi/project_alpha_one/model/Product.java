package com.khushi.project_alpha_one.model;

import java.time.LocalDate;




public class Product {
	
	
	private Long productId;
	private String productName;
	private String productDiscription;
	private Long productPrice;
	private LocalDate productExp;
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDiscription() {
		return productDiscription;
	}
	public void setProductDiscription(String productDiscription) {
		this.productDiscription = productDiscription;
	}
	public Long getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Long productPrice) {
		this.productPrice = productPrice;
	}
	public LocalDate getProductExp() {
		return productExp;
	}
	public void setProductExp(LocalDate productExp) {
		this.productExp = productExp;
	}
	
	
	@Override
	public String toString() {
		return "product [productId=" + productId + ", productName=" + productName + ", productDiscription="
				+ productDiscription + ", productPrice=" + productPrice + ", productExp=" + productExp + "]";
	}
	
	
	
}
