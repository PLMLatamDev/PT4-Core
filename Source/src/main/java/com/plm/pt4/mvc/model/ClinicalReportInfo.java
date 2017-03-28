package com.plm.pt4.mvc.model;

import java.util.List;
import com.plm.pt4.mvc.model.report.IContraindication;
import com.plm.pt4.mvc.model.report.IIMDDIinteractions;
import com.plm.pt4.mvc.model.report.IMeal;
import com.plm.pt4.mvc.model.report.IPharmacologicalGroups;
import com.plm.pt4.mvc.model.report.ISubstances;
import com.plm.pt4.mvc.model.report.ITherapeuticDoubleness;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ClinicalReportInfo {
	
   private String brand;
   private String pharmaForm;
   private String substancesDescription;
   private List<ISubstances> interactionSubstances;
   private List<IPharmacologicalGroups> pharmacologicalGroups;
   private List<IMeal> meals;
   private List<IContraindication> contraindications;
   private List<ITherapeuticDoubleness> therapeuticDoubleness;
   private List<IIMDDIinteractions> drugInteractions;
   
   public ClinicalReportInfo(){
	   
  }
   
public ClinicalReportInfo(String brand, String pharmaForm, String substancesDescription,
		List<ISubstances> interactionSubstances, List<IPharmacologicalGroups> pharmacologicalGroups, List<IMeal> meals,
		List<IContraindication> contraindications, List<ITherapeuticDoubleness> therapeuticDoubleness,
		List<IIMDDIinteractions> drugInteractions) {
	this.brand = brand;
	this.pharmaForm = pharmaForm;
	this.substancesDescription = substancesDescription;
	this.interactionSubstances = interactionSubstances;
	this.pharmacologicalGroups = pharmacologicalGroups;
	this.meals = meals;
	this.contraindications = contraindications;
	this.therapeuticDoubleness = therapeuticDoubleness;
	this.drugInteractions = drugInteractions;
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
public String getSubstancesDescription() {
	return substancesDescription;
}
public void setSubstancesDescription(String substancesDescription) {
	this.substancesDescription = substancesDescription;
}
public List<ISubstances> getInteractionSubstances() {
	return interactionSubstances;
}
public void setInteractionSubstances(List<ISubstances> interactionSubstances) {
	this.interactionSubstances = interactionSubstances;
}
public List<IPharmacologicalGroups> getPharmacologicalGroups() {
	return pharmacologicalGroups;
}
public void setPharmacologicalGroups(List<IPharmacologicalGroups> pharmacologicalGroups) {
	this.pharmacologicalGroups = pharmacologicalGroups;
}
public List<IMeal> getMeals() {
	return meals;
}
public void setMeals(List<IMeal> meals) {
	this.meals = meals;
}
public List<IContraindication> getContraindications() {
	return contraindications;
}

public void setContraindications(List<IContraindication> contraindications) {
	this.contraindications = contraindications;
}
public List<ITherapeuticDoubleness> getTherapeuticDoubleness() {
	return therapeuticDoubleness;
}

public void setTherapeuticDoubleness(List<ITherapeuticDoubleness> therapeuticDoubleness) {
	this.therapeuticDoubleness = therapeuticDoubleness;
}
public List<IIMDDIinteractions> getDrugInteractions() {
	return drugInteractions;
}

public void setDrugInteractions(List<IIMDDIinteractions> drugInteractions) {
	this.drugInteractions = drugInteractions;
}

//JASPER REPORT
public JRDataSource getInteractionsubstancesDS() {
	return new JRBeanCollectionDataSource(interactionSubstances, false);
}

public JRDataSource getIPharmacologicalGroupsDS() {
	return new JRBeanCollectionDataSource(pharmacologicalGroups, false);
}

public JRDataSource getIMealDS() {
	return new JRBeanCollectionDataSource(meals, false);
}

public JRDataSource getContraindicationDS() {
	return new JRBeanCollectionDataSource(contraindications, false);
}
public JRDataSource getTherapeuticDoublenessDS() {
	return new JRBeanCollectionDataSource(therapeuticDoubleness, false);
}
public JRDataSource getDrugInteractionDS() {
	return new JRBeanCollectionDataSource(drugInteractions, false);
}


   
   
   
}
