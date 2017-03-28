
package com.plm.pt4.mvc.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "CategotyId",
    "DivisionId",
    "ProductId",
    "PharmaFormId",
    "CategoryName",
    "DivisionShortName",
    "PharmaForm",
    "Brand",
    "PresentationId",
    "Presentation",
    "Substances",
    "Dose",
    "AdministrationRoute",
    "Time",
    "IPP",
    "IPPA"
})
public class ProductByMedicalPrescription {

    @JsonProperty("CategotyId")
    private long categotyId;
    @JsonProperty("DivisionId")
    private long divisionId;
    @JsonProperty("ProductId")
    private long productId;
    @JsonProperty("PharmaFormId")
    private long pharmaFormId;
    @JsonProperty("CategoryName")
    private String categoryName;
    @JsonProperty("DivisionShortName")
    private String divisionShortName;
    @JsonProperty("PharmaForm")
    private String pharmaForm;
    @JsonProperty("Brand")
    private String brand;
    @JsonProperty("PresentationId")
    private long presentationId;
    @JsonProperty("Presentation")
    private String presentation;
    @JsonProperty("Substances")
    private String substancesInString; 
    @JsonProperty("Dose")
    private String dose;
    @JsonProperty("AdministrationRoute")
    private String administrationRoute;
    @JsonProperty("Time")
    private String time;
    @JsonProperty("IPP")
    private String iPP;
    @JsonProperty("IPPA")
    private String iPPA;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    
    private String substances;
    /**
     * No args constructor for use in serialization
     * 
     */
    public ProductByMedicalPrescription() {
    }

    /**
     * 
     * @param pharmaFormId
     * @param divisionShortName
     * @param dose
     * @param productId
     * @param categoryName
     * @param time
     * @param iPPA
     * @param divisionId
     * @param presentation
     * @param pharmaForm
     * @param categotyId
     * @param brand
     * @param iPP
     * @param substances
     * @param presentationId
     * @param administrationRoute
     */
    public ProductByMedicalPrescription(long categotyId, long divisionId, long productId, long pharmaFormId, String categoryName, String divisionShortName, String pharmaForm, String brand, long presentationId, String presentation, String substancesInString, String dose, String administrationRoute, String time, String iPP, String iPPA) {
        this.categotyId = categotyId;
        this.divisionId = divisionId;
        this.productId = productId;
        this.pharmaFormId = pharmaFormId;
        this.categoryName = categoryName;
        this.divisionShortName = divisionShortName;
        this.pharmaForm = pharmaForm;
        this.brand = brand;
        this.presentationId = presentationId;
        this.presentation = presentation;
        this.substancesInString = substancesInString;
        this.dose = dose;
        this.administrationRoute = administrationRoute;
        this.time = time;
        this.iPP = iPP;
        this.iPPA = iPPA;
    }

    /**
     * 
     * @return
     *     The categotyId
     */
    @JsonProperty("CategotyId")
    public long getCategotyId() {
        return categotyId;
    }

    /**
     * 
     * @param categotyId
     *     The CategotyId
     */
    @JsonProperty("CategotyId")
    public void setCategotyId(long categotyId) {
        this.categotyId = categotyId;
    }

    public ProductByMedicalPrescription withCategotyId(long categotyId) {
        this.categotyId = categotyId;
        return this;
    }

    /**
     * 
     * @return
     *     The divisionId
     */
    @JsonProperty("DivisionId")
    public long getDivisionId() {
        return divisionId;
    }

    /**
     * 
     * @param divisionId
     *     The DivisionId
     */
    @JsonProperty("DivisionId")
    public void setDivisionId(long divisionId) {
        this.divisionId = divisionId;
    }

    public ProductByMedicalPrescription withDivisionId(long divisionId) {
        this.divisionId = divisionId;
        return this;
    }

    /**
     * 
     * @return
     *     The productId
     */
    @JsonProperty("ProductId")
    public long getProductId() {
        return productId;
    }

    /**
     * 
     * @param productId
     *     The ProductId
     */
    @JsonProperty("ProductId")
    public void setProductId(long productId) {
        this.productId = productId;
    }

    public ProductByMedicalPrescription withProductId(long productId) {
        this.productId = productId;
        return this;
    }

    /**
     * 
     * @return
     *     The pharmaFormId
     */
    @JsonProperty("PharmaFormId")
    public long getPharmaFormId() {
        return pharmaFormId;
    }

    /**
     * 
     * @param pharmaFormId
     *     The PharmaFormId
     */
    @JsonProperty("PharmaFormId")
    public void setPharmaFormId(long pharmaFormId) {
        this.pharmaFormId = pharmaFormId;
    }

    public ProductByMedicalPrescription withPharmaFormId(long pharmaFormId) {
        this.pharmaFormId = pharmaFormId;
        return this;
    }

    /**
     * 
     * @return
     *     The categoryName
     */
    @JsonProperty("CategoryName")
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 
     * @param categoryName
     *     The CategoryName
     */
    @JsonProperty("CategoryName")
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ProductByMedicalPrescription withCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    /**
     * 
     * @return
     *     The divisionShortName
     */
    @JsonProperty("DivisionShortName")
    public String getDivisionShortName() {
        return divisionShortName;
    }

    /**
     * 
     * @param divisionShortName
     *     The DivisionShortName
     */
    @JsonProperty("DivisionShortName")
    public void setDivisionShortName(String divisionShortName) {
        this.divisionShortName = divisionShortName;
    }

    public ProductByMedicalPrescription withDivisionShortName(String divisionShortName) {
        this.divisionShortName = divisionShortName;
        return this;
    }

    /**
     * 
     * @return
     *     The pharmaForm
     */
    @JsonProperty("PharmaForm")
    public String getPharmaForm() {
        return pharmaForm;
    }

    /**
     * 
     * @param pharmaForm
     *     The PharmaForm
     */
    @JsonProperty("PharmaForm")
    public void setPharmaForm(String pharmaForm) {
        this.pharmaForm = pharmaForm;
    }

    public ProductByMedicalPrescription withPharmaForm(String pharmaForm) {
        this.pharmaForm = pharmaForm;
        return this;
    }

    /**
     * 
     * @return
     *     The brand
     */
    @JsonProperty("Brand")
    public String getBrand() {
        return brand;
    }

    /**
     * 
     * @param brand
     *     The Brand
     */
    @JsonProperty("Brand")
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public ProductByMedicalPrescription withBrand(String brand) {
        this.brand = brand;
        return this;
    }

    /**
     * 
     * @return
     *     The presentationId
     */
    @JsonProperty("PresentationId")
    public long getPresentationId() {
        return presentationId;
    }

    /**
     * 
     * @param presentationId
     *     The PresentationId
     */
    @JsonProperty("PresentationId")
    public void setPresentationId(long presentationId) {
        this.presentationId = presentationId;
    }

    public ProductByMedicalPrescription withPresentationId(long presentationId) {
        this.presentationId = presentationId;
        return this;
    }

    /**
     * 
     * @return
     *     The presentation
     */
    @JsonProperty("Presentation")
    public String getPresentation() {
        return presentation;
    }

    /**
     * 
     * @param presentation
     *     The Presentation
     */
    @JsonProperty("Presentation")
    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public ProductByMedicalPrescription withPresentation(String presentation) {
        this.presentation = presentation;
        return this;
    }

    /**
     * 
     * @return
     *     The substances
     */
   
    public String getSubstances() {
        return substances;
    }

    /**
     * 
     * @param substances
     *     The Substances
     */
   
    public void setSubstances(String substances) {
        this.substances = substances;
    }

    public ProductByMedicalPrescription withSubstances(String substances) {
        this.substances = substances;
        return this;
    }

    /**
     * 
     * @return
     *     The dose
     */
    @JsonProperty("Dose")
    public String getDose() {
        return dose;
    }

    /**
     * 
     * @param dose
     *     The Dose
     */
    @JsonProperty("Dose")
    public void setDose(String dose) {
        this.dose = dose;
    }

    public ProductByMedicalPrescription withDose(String dose) {
        this.dose = dose;
        return this;
    }

    /**
     * 
     * @return
     *     The administrationRoute
     */
    @JsonProperty("AdministrationRoute")
    public String getAdministrationRoute() {
        return administrationRoute;
    }

    /**
     * 
     * @param administrationRoute
     *     The AdministrationRoute
     */
    @JsonProperty("AdministrationRoute")
    public void setAdministrationRoute(String administrationRoute) {
        this.administrationRoute = administrationRoute;
    }

    public ProductByMedicalPrescription withAdministrationRoute(String administrationRoute) {
        this.administrationRoute = administrationRoute;
        return this;
    }

    /**
     * 
     * @return
     *     The time
     */
    @JsonProperty("Time")
    public String getTime() {
        return time;
    }

    /**
     * 
     * @param time
     *     The Time
     */
    @JsonProperty("Time")
    public void setTime(String time) {
        this.time = time;
    }

    public ProductByMedicalPrescription withTime(String time) {
        this.time = time;
        return this;
    }

    /**
     * 
     * @return
     *     The iPP
     */
    @JsonProperty("IPP")
    public String getIPP() {
        return iPP;
    }

    /**
     * 
     * @param iPP
     *     The IPP
     */
    @JsonProperty("IPP")
    public void setIPP(String iPP) {
        this.iPP = iPP;
    }

    public ProductByMedicalPrescription withIPP(String iPP) {
        this.iPP = iPP;
        return this;
    }

    /**
     * 
     * @return
     *     The iPPA
     */
    @JsonProperty("IPPA")
    public String getIPPA() {
        return iPPA;
    }

    /**
     * 
     * @param iPPA
     *     The IPPA
     */
    @JsonProperty("IPPA")
    public void setIPPA(String iPPA) {
        this.iPPA = iPPA;
    }

    public ProductByMedicalPrescription withIPPA(String iPPA) {
        this.iPPA = iPPA;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public ProductByMedicalPrescription withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @JsonProperty("Substances")
	public String getSubstancesInString() {
		
		return substancesInString;
	}
    @JsonProperty("Substances")
	public void setSubstancesInString(String substancesInString) {
		this.substancesInString = substancesInString;
	}
    
    

}
