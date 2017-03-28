
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
    "HeaderImage",
    "ParentId",
    "SymptomChildrens",
    "SymptomColorIn",
    "SymptomColorOut",
    "SymptomId",
    "SymptomKey",
    "SymptomName",
    "Url"
})
public class GetSymptomsByEditionResult {

    @JsonProperty("HeaderImage")
    private String headerImage;
    @JsonProperty("ParentId")
    private long parentId;
    @JsonProperty("SymptomChildrens")
    private List<Object> symptomChildrens = null;
    @JsonProperty("SymptomColorIn")
    private String symptomColorIn;
    @JsonProperty("SymptomColorOut")
    private String symptomColorOut;
    @JsonProperty("SymptomId")
    private long symptomId;
    @JsonProperty("SymptomKey")
    private String symptomKey;
    @JsonProperty("SymptomName")
    private String symptomName;
    @JsonProperty("Url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GetSymptomsByEditionResult() {
    }

    /**
     * 
     * @param symptomName
     * @param symptomColorIn
     * @param parentId
     * @param headerImage
     * @param symptomId
     * @param symptomKey
     * @param symptomColorOut
     * @param symptomChildrens
     * @param url
     */
    public GetSymptomsByEditionResult(String headerImage, long parentId, List<Object> symptomChildrens, String symptomColorIn, String symptomColorOut, long symptomId, String symptomKey, String symptomName, String url) {
        super();
        this.headerImage = headerImage;
        this.parentId = parentId;
        this.symptomChildrens = symptomChildrens;
        this.symptomColorIn = symptomColorIn;
        this.symptomColorOut = symptomColorOut;
        this.symptomId = symptomId;
        this.symptomKey = symptomKey;
        this.symptomName = symptomName;
        this.url = url;
    }

    @JsonProperty("HeaderImage")
    public String getHeaderImage() {
        return headerImage;
    }

    @JsonProperty("HeaderImage")
    public void setHeaderImage(String headerImage) {
        this.headerImage = headerImage;
    }

    public GetSymptomsByEditionResult withHeaderImage(String headerImage) {
        this.headerImage = headerImage;
        return this;
    }

    @JsonProperty("ParentId")
    public long getParentId() {
        return parentId;
    }

    @JsonProperty("ParentId")
    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public GetSymptomsByEditionResult withParentId(long parentId) {
        this.parentId = parentId;
        return this;
    }

    @JsonProperty("SymptomChildrens")
    public List<Object> getSymptomChildrens() {
        return symptomChildrens;
    }

    @JsonProperty("SymptomChildrens")
    public void setSymptomChildrens(List<Object> symptomChildrens) {
        this.symptomChildrens = symptomChildrens;
    }

    public GetSymptomsByEditionResult withSymptomChildrens(List<Object> symptomChildrens) {
        this.symptomChildrens = symptomChildrens;
        return this;
    }

    @JsonProperty("SymptomColorIn")
    public String getSymptomColorIn() {
        return symptomColorIn;
    }

    @JsonProperty("SymptomColorIn")
    public void setSymptomColorIn(String symptomColorIn) {
        this.symptomColorIn = symptomColorIn;
    }

    public GetSymptomsByEditionResult withSymptomColorIn(String symptomColorIn) {
        this.symptomColorIn = symptomColorIn;
        return this;
    }

    @JsonProperty("SymptomColorOut")
    public String getSymptomColorOut() {
        return symptomColorOut;
    }

    @JsonProperty("SymptomColorOut")
    public void setSymptomColorOut(String symptomColorOut) {
        this.symptomColorOut = symptomColorOut;
    }

    public GetSymptomsByEditionResult withSymptomColorOut(String symptomColorOut) {
        this.symptomColorOut = symptomColorOut;
        return this;
    }

    @JsonProperty("SymptomId")
    public long getSymptomId() {
        return symptomId;
    }

    @JsonProperty("SymptomId")
    public void setSymptomId(long symptomId) {
        this.symptomId = symptomId;
    }

    public GetSymptomsByEditionResult withSymptomId(long symptomId) {
        this.symptomId = symptomId;
        return this;
    }

    @JsonProperty("SymptomKey")
    public String getSymptomKey() {
        return symptomKey;
    }

    @JsonProperty("SymptomKey")
    public void setSymptomKey(String symptomKey) {
        this.symptomKey = symptomKey;
    }

    public GetSymptomsByEditionResult withSymptomKey(String symptomKey) {
        this.symptomKey = symptomKey;
        return this;
    }

    @JsonProperty("SymptomName")
    public String getSymptomName() {
        return symptomName;
    }

    @JsonProperty("SymptomName")
    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName;
    }

    public GetSymptomsByEditionResult withSymptomName(String symptomName) {
        this.symptomName = symptomName;
        return this;
    }

    @JsonProperty("Url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("Url")
    public void setUrl(String url) {
        this.url = url;
    }

    public GetSymptomsByEditionResult withUrl(String url) {
        this.url = url;
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

    public GetSymptomsByEditionResult withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
