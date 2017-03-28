
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
    "getEncyclopediaAttributesByProductsEditionResult"
})
public class EncyclopediaDetail {

    @JsonProperty("getEncyclopediaAttributesByProductsEditionResult")
    private GetEncyclopediaAttributesByProductsEditionResult getEncyclopediaAttributesByProductsEditionResult;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public EncyclopediaDetail() {
    }

    /**
     * 
     * @param getEncyclopediaAttributesByProductsEditionResult
     */
    public EncyclopediaDetail(GetEncyclopediaAttributesByProductsEditionResult getEncyclopediaAttributesByProductsEditionResult) {
        super();
        this.getEncyclopediaAttributesByProductsEditionResult = getEncyclopediaAttributesByProductsEditionResult;
    }

    @JsonProperty("getEncyclopediaAttributesByProductsEditionResult")
    public GetEncyclopediaAttributesByProductsEditionResult getGetEncyclopediaAttributesByProductsEditionResult() {
        return getEncyclopediaAttributesByProductsEditionResult;
    }

    @JsonProperty("getEncyclopediaAttributesByProductsEditionResult")
    public void setGetEncyclopediaAttributesByProductsEditionResult(GetEncyclopediaAttributesByProductsEditionResult getEncyclopediaAttributesByProductsEditionResult) {
        this.getEncyclopediaAttributesByProductsEditionResult = getEncyclopediaAttributesByProductsEditionResult;
    }

    public EncyclopediaDetail withGetEncyclopediaAttributesByProductsEditionResult(GetEncyclopediaAttributesByProductsEditionResult getEncyclopediaAttributesByProductsEditionResult) {
        this.getEncyclopediaAttributesByProductsEditionResult = getEncyclopediaAttributesByProductsEditionResult;
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

    public EncyclopediaDetail withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
