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
    "Brand",
    "CategotyId",
    "DivisionId",
    "DivisionName",
    "IPPA",
    "PharmaForm",
    "PharmaFormId",
    "Presentation",
    "ProductId",
    "Substance"
})
public class SelectedDrugs {

    @JsonProperty("Brand")
    private String brand;
    @JsonProperty("CategotyId")
    private long categotyId;
    @JsonProperty("DivisionId")
    private long divisionId;
    @JsonProperty("DivisionName")
    private String divisionName;
    @JsonProperty("IPPA")
    private String iPPA;
    @JsonProperty("PharmaForm")
    private String pharmaForm;
    @JsonProperty("PharmaFormId")
    private long pharmaFormId;
    @JsonProperty("Presentation")
    private String presentation;
    @JsonProperty("ProductId")
    private long productId;
    @JsonProperty("Substance")
    private String substance;
    @JsonProperty("PresentationId")
    private long presentationId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    private boolean activeIM;
    private boolean activeDDI;
    private boolean activeIMA;
    private boolean activeCON;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SelectedDrugs() {
    }

    /**
     * 
     * @param substance
     * @param iPPA
     * @param presentation
     * @param divisionName
     * @param divisionId
     * @param pharmaFormId
     * @param pharmaForm
     * @param categotyId
     * @param brand
    * @param productId
    * @param presentationId
     */
    public SelectedDrugs(String brand, long categotyId, long divisionId, String divisionName, String iPPA, String pharmaForm, long pharmaFormId, String presentation, long productId, String substance, long presentationId) {
        this.brand = brand;
        this.categotyId = categotyId;
        this.divisionId = divisionId;
        this.divisionName = divisionName;
        this.iPPA = iPPA;
        this.pharmaForm = pharmaForm;
        this.pharmaFormId = pharmaFormId;
        this.presentation = presentation;
        this.productId = productId;
        this.substance = substance;
        this.presentationId = presentationId;
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

    /**
     * 
     * @return
     *     The divisionName
     */
    @JsonProperty("DivisionName")
    public String getDivisionName() {
        return divisionName;
    }

    /**
     * 
     * @param divisionName
     *     The DivisionName
     */
    @JsonProperty("DivisionName")
    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
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

    /**
     * 
     * @return
     *     The substance
     */
    @JsonProperty("Substance")
    public String getSubstance() {
        return substance;
    }

    /**
     * 
     * @param substance
     *     The Substance
     */
    @JsonProperty("Substance")
    public void setSubstance(String substance) {
        this.substance = substance;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    
    public void setActiveIM(boolean activeIM){this. activeIM =  activeIM;}
    public void setActiveDDI(boolean activeDDI){this.activeDDI = activeDDI;}
    public void setActiveIMA(boolean activeIMA){this.activeIMA = activeIMA;}
    public void setActiveCON(boolean activeCON){this.activeCON = activeCON;}

    public boolean getActiveIM(){return this. activeIM;}
    public boolean getActiveDDI(){return this.activeDDI;}
    public boolean getActiveIMA(){return this.activeIMA;}
    public boolean getActiveCON(){return this.activeCON;}

    
    
}
