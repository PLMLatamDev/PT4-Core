package com.plm.pt4.mvc.model.report;

public class ISubstances {

	private String brand;
	private String activeSubstance;
	private String pharmaForm;
	private String divisionShortName;
	
	public ISubstances(){
		
	}

	
	public ISubstances(String brand, String activeSubstance, String pharmaForm, String divisionShortName) {
		this.brand = brand;
		this.activeSubstance = activeSubstance;
		this.pharmaForm = pharmaForm;
		this.divisionShortName = divisionShortName;
	}


	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getActiveSubstance() {
		return activeSubstance;
	}

	public void setActiveSubstance(String activeSubstance) {
		this.activeSubstance = activeSubstance;
	}

	public String getPharmaForm() {
		return pharmaForm;
	}

	public void setPharmaForm(String pharmaForm) {
		this.pharmaForm = pharmaForm;
	}

	public String getDivisionShortName() {
		return divisionShortName;
	}

	public void setDivisionShortName(String divisionShortName) {
		this.divisionShortName = divisionShortName;
	}
	
	
	
}
