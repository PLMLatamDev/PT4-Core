package com.plm.pt4.mvc.model.report;

import java.util.List;

import com.plmlatina.model.ClinicalReference;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class IMeal {
	private String description;
	private String mealElementDescription;
	private String imaSeverity;
	private String clinicalSumary;
	private List<ClinicalReference> clinicalReferences;
	
	public IMeal(){
		
	}

	public IMeal(String description, String mealElementDescription, String imaSeverity, String clinicalSumary, List<ClinicalReference> clinicalReferences) {
		this.description = description;
		this.mealElementDescription = mealElementDescription;
		this.imaSeverity = imaSeverity;
		this.clinicalSumary = clinicalSumary;
		this.clinicalReferences = clinicalReferences;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMealElementDescription() {
		return mealElementDescription;
	}

	public void setMealElementDescription(String mealElementDescription) {
		this.mealElementDescription = mealElementDescription;
	}

	public String getImaSeverity() {
		return imaSeverity;
	}

	public void setImaSeverity(String imaSeverity) {
		this.imaSeverity = imaSeverity;
	}

	public String getClinicalSumary() {
		return clinicalSumary;
	}

	public void setClinicalSumary(String clinicalSumary) {
		this.clinicalSumary = clinicalSumary;
	}

	public List<ClinicalReference> getClinicalReferences() {
		return clinicalReferences;
	}

	public void setClinicalReferences(List<ClinicalReference> clinicalReferences) {
		this.clinicalReferences = clinicalReferences;
	}

	//JASPER REPORT
	public JRDataSource getClinicalReferencesDS() {
		return new JRBeanCollectionDataSource(clinicalReferences, false);
	}
	
    	

}
