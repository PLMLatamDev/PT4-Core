
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
    "getSymptomsByEditionResult"
})
public class SymptomsByEditionResult {

    @JsonProperty("getSymptomsByEditionResult")
    private List<GetSymptomsByEditionResult> getSymptomsByEditionResult = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SymptomsByEditionResult() {
    }

    /**
     * 
     * @param getSymptomsByEditionResult
     */
    public SymptomsByEditionResult(List<GetSymptomsByEditionResult> getSymptomsByEditionResult) {
        super();
        this.getSymptomsByEditionResult = getSymptomsByEditionResult;
    }

    @JsonProperty("getSymptomsByEditionResult")
    public List<GetSymptomsByEditionResult> getGetSymptomsByEditionResult() {
        return getSymptomsByEditionResult;
    }

    @JsonProperty("getSymptomsByEditionResult")
    public void setGetSymptomsByEditionResult(List<GetSymptomsByEditionResult> getSymptomsByEditionResult) {
        this.getSymptomsByEditionResult = getSymptomsByEditionResult;
    }

    public SymptomsByEditionResult withGetSymptomsByEditionResult(List<GetSymptomsByEditionResult> getSymptomsByEditionResult) {
        this.getSymptomsByEditionResult = getSymptomsByEditionResult;
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

    public SymptomsByEditionResult withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
