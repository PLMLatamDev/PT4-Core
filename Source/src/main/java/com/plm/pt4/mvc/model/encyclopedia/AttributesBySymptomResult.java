
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
    "getAttributesBySymptomResult"
})
public class AttributesBySymptomResult {

    @JsonProperty("getAttributesBySymptomResult")
    private List<GetAttributesBySymptomResult> getAttributesBySymptomResult = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AttributesBySymptomResult() {
    }

    /**
     * 
     * @param getAttributesBySymptomResult
     */
    public AttributesBySymptomResult(List<GetAttributesBySymptomResult> getAttributesBySymptomResult) {
        super();
        this.getAttributesBySymptomResult = getAttributesBySymptomResult;
    }

    @JsonProperty("getAttributesBySymptomResult")
    public List<GetAttributesBySymptomResult> getGetAttributesBySymptomResult() {
        return getAttributesBySymptomResult;
    }

    @JsonProperty("getAttributesBySymptomResult")
    public void setGetAttributesBySymptomResult(List<GetAttributesBySymptomResult> getAttributesBySymptomResult) {
        this.getAttributesBySymptomResult = getAttributesBySymptomResult;
    }

    public AttributesBySymptomResult withGetAttributesBySymptomResult(List<GetAttributesBySymptomResult> getAttributesBySymptomResult) {
        this.getAttributesBySymptomResult = getAttributesBySymptomResult;
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

    public AttributesBySymptomResult withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
