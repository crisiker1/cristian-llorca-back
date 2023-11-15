package com.cristianprueba.app.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO para Prices
 * Hay campos de la entidad que no se requieren en el Dto
 * 
 */
public class PriceDto {
	
	@JsonProperty(value = "productId")
	private Integer productId;
	
	@JsonProperty(value = "startDate")
	private String startDate;
	
	@JsonProperty(value = "endDate")
	private String endDate;
	
	@JsonProperty(value = "priceList")
	private Integer priceList;
	
	@JsonProperty(value = "price")
	private Double price;
	
	@JsonProperty(value = "brandId")
	private Integer brandId;
	
	// Tambien se podria usar Lombok
	public PriceDto(Integer productId, String startDate, String endDate, Integer priceList, Double price,
			Integer brandId) {
		super();
		this.productId = productId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceList = priceList;
		this.price = price;
		this.brandId = brandId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getPriceList() {
		return priceList;
	}

	public void setPriceList(Integer priceList) {
		this.priceList = priceList;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

}
