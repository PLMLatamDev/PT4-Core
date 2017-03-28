package com.plm.pt4.mvc.model.report;

import java.util.List;

import com.plmlatina.model.IMDDIReference;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class IIMDDIinteractions {
 private String brand;
 private String activeSubstance;
 private String pharmaForm;
 private String divisionShortName;
 private String colorSemaphore;
 private List<IMDDIReference> imddiReferences;
 
 public IIMDDIinteractions(){
	 
 }

public IIMDDIinteractions(String brand, String activeSubstance, String pharmaForm, String divisionShortName,
		String colorSemaphore, List<IMDDIReference> imddiReferences) {
	this.brand = brand;
	this.activeSubstance = activeSubstance;
	this.pharmaForm = pharmaForm;
	this.divisionShortName = divisionShortName;
	this.colorSemaphore = colorSemaphore;
	this.imddiReferences = imddiReferences;
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


public String getColorSemaphore() {
	return colorSemaphore;
}


public void setColorSemaphore(String colorSemaphore) {
	this.colorSemaphore = colorSemaphore;
}

public List<IMDDIReference> getImddiReferences() {
	return imddiReferences;
}

public void setImddiReferences(List<IMDDIReference> imddiReferences) {
	this.imddiReferences = imddiReferences;
}

//JASPER REPORT
	public JRDataSource getReferencesDS() {
		return new JRBeanCollectionDataSource(imddiReferences, false);
	}

 
 
}
