
package com.plm.pt4.mvc.model.encyclopedia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Active",
    "AssociatedEncyclopedias",
    "AssociatedProducts",
    "AssociatedSicknesses",
    "Attributes",
    "BaseUrl",
    "EncyclopediaId",
    "EncyclopediaImage",
    "EncyclopediaName",
    "EncyclopediaTypeId",
    "MedicalSpecialities",
    "MiniatureBaseUrl",
    "PLMCode"
})
public class GetEncyclopediaAttributesByProductsEditionResult {

    @JsonProperty("Active")
    private boolean active;
    @JsonProperty("AssociatedEncyclopedias")
    private List<AssociatedEncyclopedia> associatedEncyclopedias = null;
    @JsonProperty("AssociatedProducts")
    private List<AssociatedProduct> associatedProducts = null;
    @JsonProperty("AssociatedSicknesses")
    private List<AssociatedSickness> associatedSicknesses = null;
    @JsonProperty("Attributes")
    private List<Attribute> attributes = null;
    @JsonProperty("BaseUrl")
    private String baseUrl;
    @JsonProperty("EncyclopediaId")
    private long encyclopediaId;
    @JsonProperty("EncyclopediaImage")
    private String encyclopediaImage;
    @JsonProperty("EncyclopediaName")
    private String encyclopediaName;
    @JsonProperty("EncyclopediaTypeId")
    private long encyclopediaTypeId;
    @JsonProperty("MedicalSpecialities")
    private List<MedicalSpeciality> medicalSpecialities = null;
    @JsonProperty("MiniatureBaseUrl")
    private String miniatureBaseUrl;
    @JsonProperty("PLMCode")
    private String pLMCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GetEncyclopediaAttributesByProductsEditionResult() {
    }

    /**
     * 
     * @param associatedEncyclopedias
     * @param encyclopediaTypeId
     * @param miniatureBaseUrl
     * @param medicalSpecialities
     * @param associatedProducts
     * @param associatedSicknesses
     * @param pLMCode
     * @param encyclopediaId
     * @param encyclopediaImage
     * @param baseUrl
     * @param active
     * @param attributes
     * @param encyclopediaName
     */
    public GetEncyclopediaAttributesByProductsEditionResult(boolean active, List<AssociatedEncyclopedia> associatedEncyclopedias, List<AssociatedProduct> associatedProducts, List<AssociatedSickness> associatedSicknesses, List<Attribute> attributes, String baseUrl, long encyclopediaId, String encyclopediaImage, String encyclopediaName, long encyclopediaTypeId, List<MedicalSpeciality> medicalSpecialities, String miniatureBaseUrl, String pLMCode) {
        super();
        this.active = active;
        this.associatedEncyclopedias = associatedEncyclopedias;
        this.associatedProducts = associatedProducts;
        this.associatedSicknesses = associatedSicknesses;
        this.attributes = attributes;
        this.baseUrl = baseUrl;
        this.encyclopediaId = encyclopediaId;
        this.encyclopediaImage = encyclopediaImage;
        this.encyclopediaName = encyclopediaName;
        this.encyclopediaTypeId = encyclopediaTypeId;
        this.medicalSpecialities = medicalSpecialities;
        this.miniatureBaseUrl = miniatureBaseUrl;
        this.pLMCode = pLMCode;
    }

    @JsonProperty("Active")
    public boolean isActive() {
        return active;
    }

    @JsonProperty("Active")
    public void setActive(boolean active) {
        this.active = active;
    }

    public GetEncyclopediaAttributesByProductsEditionResult withActive(boolean active) {
        this.active = active;
        return this;
    }

    @JsonProperty("AssociatedEncyclopedias")
    public List<AssociatedEncyclopedia> getAssociatedEncyclopedias() {
        return associatedEncyclopedias;
    }

    @JsonProperty("AssociatedEncyclopedias")
    public void setAssociatedEncyclopedias(List<AssociatedEncyclopedia> associatedEncyclopedias) {
        this.associatedEncyclopedias = associatedEncyclopedias;
    }

    public GetEncyclopediaAttributesByProductsEditionResult withAssociatedEncyclopedias(List<AssociatedEncyclopedia> associatedEncyclopedias) {
        this.associatedEncyclopedias = associatedEncyclopedias;
        return this;
    }

    @JsonProperty("AssociatedProducts")
    public List<AssociatedProduct> getAssociatedProducts() {
        return associatedProducts;
    }

    @JsonProperty("AssociatedProducts")
    public void setAssociatedProducts(List<AssociatedProduct> associatedProducts) {
        this.associatedProducts = associatedProducts;
    }

    public GetEncyclopediaAttributesByProductsEditionResult withAssociatedProducts(List<AssociatedProduct> associatedProducts) {
        this.associatedProducts = associatedProducts;
        return this;
    }

    @JsonProperty("AssociatedSicknesses")
    public List<AssociatedSickness> getAssociatedSicknesses() {
        return associatedSicknesses;
    }

    @JsonProperty("AssociatedSicknesses")
    public void setAssociatedSicknesses(List<AssociatedSickness> associatedSicknesses) {
        this.associatedSicknesses = associatedSicknesses;
    }

    public GetEncyclopediaAttributesByProductsEditionResult withAssociatedSicknesses(List<AssociatedSickness> associatedSicknesses) {
        this.associatedSicknesses = associatedSicknesses;
        return this;
    }

    @JsonProperty("Attributes")
    public List<Attribute> getAttributes() {
        return attributes;
    }

    @JsonProperty("Attributes")
    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public GetEncyclopediaAttributesByProductsEditionResult withAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
        return this;
    }

    @JsonProperty("BaseUrl")
    public String getBaseUrl() {
        return baseUrl;
    }

    @JsonProperty("BaseUrl")
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public GetEncyclopediaAttributesByProductsEditionResult withBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    @JsonProperty("EncyclopediaId")
    public long getEncyclopediaId() {
        return encyclopediaId;
    }

    @JsonProperty("EncyclopediaId")
    public void setEncyclopediaId(long encyclopediaId) {
        this.encyclopediaId = encyclopediaId;
    }

    public GetEncyclopediaAttributesByProductsEditionResult withEncyclopediaId(long encyclopediaId) {
        this.encyclopediaId = encyclopediaId;
        return this;
    }

    @JsonProperty("EncyclopediaImage")
    public String getEncyclopediaImage() {
        return encyclopediaImage;
    }

    @JsonProperty("EncyclopediaImage")
    public void setEncyclopediaImage(String encyclopediaImage) {
        this.encyclopediaImage = encyclopediaImage;
    }

    public GetEncyclopediaAttributesByProductsEditionResult withEncyclopediaImage(String encyclopediaImage) {
        this.encyclopediaImage = encyclopediaImage;
        return this;
    }

    @JsonProperty("EncyclopediaName")
    public String getEncyclopediaName() {
        return encyclopediaName;
    }

    @JsonProperty("EncyclopediaName")
    public void setEncyclopediaName(String encyclopediaName) {
        this.encyclopediaName = encyclopediaName;
    }

    public GetEncyclopediaAttributesByProductsEditionResult withEncyclopediaName(String encyclopediaName) {
        this.encyclopediaName = encyclopediaName;
        return this;
    }

    @JsonProperty("EncyclopediaTypeId")
    public long getEncyclopediaTypeId() {
        return encyclopediaTypeId;
    }

    @JsonProperty("EncyclopediaTypeId")
    public void setEncyclopediaTypeId(long encyclopediaTypeId) {
        this.encyclopediaTypeId = encyclopediaTypeId;
    }

    public GetEncyclopediaAttributesByProductsEditionResult withEncyclopediaTypeId(long encyclopediaTypeId) {
        this.encyclopediaTypeId = encyclopediaTypeId;
        return this;
    }

    @JsonProperty("MedicalSpecialities")
    public List<MedicalSpeciality> getMedicalSpecialities() {
        return medicalSpecialities;
    }

    @JsonProperty("MedicalSpecialities")
    public void setMedicalSpecialities(List<MedicalSpeciality> medicalSpecialities) {
        this.medicalSpecialities = medicalSpecialities;
    }

    public GetEncyclopediaAttributesByProductsEditionResult withMedicalSpecialities(List<MedicalSpeciality> medicalSpecialities) {
        this.medicalSpecialities = medicalSpecialities;
        return this;
    }

    @JsonProperty("MiniatureBaseUrl")
    public String getMiniatureBaseUrl() {
        return miniatureBaseUrl;
    }

    @JsonProperty("MiniatureBaseUrl")
    public void setMiniatureBaseUrl(String miniatureBaseUrl) {
        this.miniatureBaseUrl = miniatureBaseUrl;
    }

    public GetEncyclopediaAttributesByProductsEditionResult withMiniatureBaseUrl(String miniatureBaseUrl) {
        this.miniatureBaseUrl = miniatureBaseUrl;
        return this;
    }

    @JsonProperty("PLMCode")
    public String getPLMCode() {
        return pLMCode;
    }

    @JsonProperty("PLMCode")
    public void setPLMCode(String pLMCode) {
        this.pLMCode = pLMCode;
    }

    public GetEncyclopediaAttributesByProductsEditionResult withPLMCode(String pLMCode) {
        this.pLMCode = pLMCode;
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

    public GetEncyclopediaAttributesByProductsEditionResult withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
