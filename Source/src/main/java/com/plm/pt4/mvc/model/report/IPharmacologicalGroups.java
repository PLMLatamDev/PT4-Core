package com.plm.pt4.mvc.model.report;

public class IPharmacologicalGroups {
	private String groupName;
	private String activeSubstance;
	private String brand;
	private String pharmaForm;
	
	public IPharmacologicalGroups(){
		
	}
	
	public IPharmacologicalGroups(String groupName, String activeSubstance, String brand, String pharmaForm) {
		this.groupName = groupName;
		this.activeSubstance = activeSubstance;
		this.brand = brand;
		this.pharmaForm = pharmaForm;
	}

	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getActiveSubstance() {
		return activeSubstance;
	}
	public void setActiveSubstance(String activeSubstance) {
		this.activeSubstance = activeSubstance;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPharmaForm() {
		return pharmaForm;
	}
	public void setPharmaForm(String pharmaForm) {
		this.pharmaForm = pharmaForm;
	}
	
	

}
