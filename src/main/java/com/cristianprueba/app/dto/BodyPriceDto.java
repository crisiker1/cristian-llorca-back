package com.cristianprueba.app.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO Body Prices
 * 
 */
public class BodyPriceDto {
	
	@JsonProperty(value = "appDate")
	private String appDate;
	
	@JsonProperty(value = "productId")
	private Integer productId;
	
	@JsonProperty(value = "brandId")
	private Integer brandId;
	
	// Tambien se podria usar Lombok
	public BodyPriceDto(String appDate, Integer productId, Integer brandId) {
		super();
		this.appDate = appDate;
		this.productId = productId;
		this.brandId = brandId;
	}

	public String getAppDate() {
		return appDate;
	}

	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

}
