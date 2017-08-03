package cn.jbit.entity;

import java.math.BigDecimal;

public class Productinformation {
	
	public Long productId;
	public String productType;
	public String gramWeight;
	public String brand;
	public BigDecimal productPrice;
	public Integer bepertory;
	public String detailpage;
	public String productName;
	public Integer productStatus;
	public Productinformation() {
		super();
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getGramWeight() {
		return gramWeight;
	}
	public void setGramWeight(String gramWeight) {
		this.gramWeight = gramWeight;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getBepertory() {
		return bepertory;
	}
	public void setBepertory(Integer bepertory) {
		this.bepertory = bepertory;
	}
	public String getDetailpage() {
		return detailpage;
	}
	public void setDetailpage(String detailpage) {
		this.detailpage = detailpage;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}
	public String toString() {
		return "Productinformation [productId=" + productId + ", productType=" + productType
				+ ", gramWeight=" + gramWeight + ", brand=" + brand + ", productPrice="
				+ productPrice + ", bepertory=" + bepertory + ", detailpage=" + detailpage
				+ ", productName=" + productName + ", productStatus=" + productStatus + "]";
	}
	
	
}
