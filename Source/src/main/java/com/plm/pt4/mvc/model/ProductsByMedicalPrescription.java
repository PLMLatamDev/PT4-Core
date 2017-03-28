package com.plm.pt4.mvc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "Products",
    "Recommendations",
    "Idx"
})
public class ProductsByMedicalPrescription {

    @JsonProperty("Products")
    private List<ProductByMedicalPrescription> products = new ArrayList<ProductByMedicalPrescription>();
    @JsonProperty("Recommendations")
    private String recommendations;
    @JsonProperty("Idx")
    private String idx;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ProductsByMedicalPrescription() {
    }

    /**
     * 
     * @param idx
     * @param recommendations
     * @param products
     */
    public ProductsByMedicalPrescription(List<ProductByMedicalPrescription> products, String recommendations, String idx) {
        this.products = products;
        this.recommendations = recommendations;
        this.idx = idx;
    }

    /**
     * 
     * @return
     *     The products
     */
    @JsonProperty("Products")
    public List<ProductByMedicalPrescription> getProducts() {
        return products;
    }

    /**
     * 
     * @param products
     *     The Products
     */
    @JsonProperty("Products")
    public void setProducts(List<ProductByMedicalPrescription> products) {
        this.products = products;
    }

    public ProductsByMedicalPrescription withProducts(List<ProductByMedicalPrescription> products) {
        this.products = products;
        return this;
    }

    /**
     * 
     * @return
     *     The recommendations
     */
    @JsonProperty("Recommendations")
    public String getRecommendations() {
        return recommendations;
    }

    /**
     * 
     * @param recommendations
     *     The Recommendations
     */
    @JsonProperty("Recommendations")
    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    public ProductsByMedicalPrescription withRecommendations(String recommendations) {
        this.recommendations = recommendations;
        return this;
    }

    /**
     * 
     * @return
     *     The idx
     */
    @JsonProperty("Idx")
    public String getIdx() {
        return idx;
    }

    /**
     * 
     * @param idx
     *     The Idx
     */
    @JsonProperty("Idx")
    public void setIdx(String idx) {
        this.idx = idx;
    }

    public ProductsByMedicalPrescription withIdx(String idx) {
        this.idx = idx;
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

    public ProductsByMedicalPrescription withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
