package com.plm.pt4.mvc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)

public class Prescription {
	
	@JsonProperty("categotyId")
	private int categotyId;
	
	@JsonProperty("divisionId")
	private int divisionId;
	
	@JsonProperty("pharmaFormId")
	private int pharmaFormId;
	
	@JsonProperty("productId")
	private int productId;
	
	@JsonProperty("ippa")
	private String ippa;
	
	public int getCategotyId() {
		return categotyId;
	}
	public void setCategotyId(int categotyId) {
		this.categotyId = categotyId;
	}
	public int getDivisionId() {
		return divisionId;
	}
	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}
	public int getPharmaFormId() {
		return pharmaFormId;
	}
	public void setPharmaFormId(int pharmaFormId) {
		this.pharmaFormId = pharmaFormId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getIppa() {
		return ippa;
	}
	public void setIppa(String ippa) {
		this.ippa = ippa;
	}

}
