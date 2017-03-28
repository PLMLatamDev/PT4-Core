package com.plm.pt4.mvc.model.report;

import java.util.List;

import com.plmlatina.model.ATCOMSDoublenessProduct;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ITherapeuticDoubleness {
	private List<ATCOMSDoublenessProduct> brands;
	private String description;
 
	public ITherapeuticDoubleness(){
		
	}

	public ITherapeuticDoubleness(List<ATCOMSDoublenessProduct> brands, String description) {
		this.brands = brands;
		this.description = description;
	}

	public List<ATCOMSDoublenessProduct> getBrand() {
		return brands;
	}

	public void setBrand(List<ATCOMSDoublenessProduct> brands) {
		this.brands = brands;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	//JASPER REPORT
	public JRDataSource getBrandsDS() {
		return new JRBeanCollectionDataSource(brands, false);
	}
 
	
}
