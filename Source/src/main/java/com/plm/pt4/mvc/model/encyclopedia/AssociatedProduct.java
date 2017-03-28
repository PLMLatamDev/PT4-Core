
package com.plm.pt4.mvc.model.encyclopedia;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Brand",
    "CategoryId",
    "CategoryName",
    "DivisionId",
    "DivisionName",
    "DivisionShortName",
    "PharmaForm",
    "PharmaFormId",
    "ProductId"
})
public class AssociatedProduct {

    @JsonProperty("Brand")
    private String brand;
    @JsonProperty("CategoryId")
    private long categoryId;
    @JsonProperty("CategoryName")
    private String categoryName;
    @JsonProperty("DivisionId")
    private long divisionId;
    @JsonProperty("DivisionName")
    private String divisionName;
    @JsonProperty("DivisionShortName")
    private String divisionShortName;
    @JsonProperty("PharmaForm")
    private String pharmaForm;
    @JsonProperty("PharmaFormId")
    private long pharmaFormId;
    @JsonProperty("ProductId")
    private long productId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AssociatedProduct() {
    }

    /**
     * 
     * @param categoryName
     * @param divisionName
     * @param divisionId
     * @param pharmaFormId
     * @param categoryId
     * @param pharmaForm
     * @param brand
     * @param divisionShortName
     * @param productId
     */
    public AssociatedProduct(String brand, long categoryId, String categoryName, long divisionId, String divisionName, String divisionShortName, String pharmaForm, long pharmaFormId, long productId) {
        super();
        this.brand = brand;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.divisionId = divisionId;
        this.divisionName = divisionName;
        this.divisionShortName = divisionShortName;
        this.pharmaForm = pharmaForm;
        this.pharmaFormId = pharmaFormId;
        this.productId = productId;
    }

    @JsonProperty("Brand")
    public String getBrand() {
        return brand;
    }

    @JsonProperty("Brand")
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public AssociatedProduct withBrand(String brand) {
        this.brand = brand;
        return this;
    }

    @JsonProperty("CategoryId")
    public long getCategoryId() {
        return categoryId;
    }

    @JsonProperty("CategoryId")
    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public AssociatedProduct withCategoryId(long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    @JsonProperty("CategoryName")
    public String getCategoryName() {
        return categoryName;
    }

    @JsonProperty("CategoryName")
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public AssociatedProduct withCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    @JsonProperty("DivisionId")
    public long getDivisionId() {
        return divisionId;
    }

    @JsonProperty("DivisionId")
    public void setDivisionId(long divisionId) {
        this.divisionId = divisionId;
    }

    public AssociatedProduct withDivisionId(long divisionId) {
        this.divisionId = divisionId;
        return this;
    }

    @JsonProperty("DivisionName")
    public String getDivisionName() {
        return divisionName;
    }

    @JsonProperty("DivisionName")
    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public AssociatedProduct withDivisionName(String divisionName) {
        this.divisionName = divisionName;
        return this;
    }

    @JsonProperty("DivisionShortName")
    public String getDivisionShortName() {
        return divisionShortName;
    }

    @JsonProperty("DivisionShortName")
    public void setDivisionShortName(String divisionShortName) {
        this.divisionShortName = divisionShortName;
    }

    public AssociatedProduct withDivisionShortName(String divisionShortName) {
        this.divisionShortName = divisionShortName;
        return this;
    }

    @JsonProperty("PharmaForm")
    public String getPharmaForm() {
        return pharmaForm;
    }

    @JsonProperty("PharmaForm")
    public void setPharmaForm(String pharmaForm) {
        this.pharmaForm = pharmaForm;
    }

    public AssociatedProduct withPharmaForm(String pharmaForm) {
        this.pharmaForm = pharmaForm;
        return this;
    }

    @JsonProperty("PharmaFormId")
    public long getPharmaFormId() {
        return pharmaFormId;
    }

    @JsonProperty("PharmaFormId")
    public void setPharmaFormId(long pharmaFormId) {
        this.pharmaFormId = pharmaFormId;
    }

    public AssociatedProduct withPharmaFormId(long pharmaFormId) {
        this.pharmaFormId = pharmaFormId;
        return this;
    }

    @JsonProperty("ProductId")
    public long getProductId() {
        return productId;
    }

    @JsonProperty("ProductId")
    public void setProductId(long productId) {
        this.productId = productId;
    }

    public AssociatedProduct withProductId(long productId) {
        this.productId = productId;
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

    public AssociatedProduct withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
