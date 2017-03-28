
package com.plm.pt4.mvc.model;

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
    "getEncyclopediasByTypeByTextResult"
})
public class EncyclopediaTest {

    @JsonProperty("getEncyclopediasByTypeByTextResult")
    private List<GetEncyclopediasByTypeByTextResult> getEncyclopediasByTypeByTextResult = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public EncyclopediaTest() {
    }

    /**
     * 
     * @param getEncyclopediasByTypeByTextResult
     */
    public EncyclopediaTest(List<GetEncyclopediasByTypeByTextResult> getEncyclopediasByTypeByTextResult) {
        super();
        this.getEncyclopediasByTypeByTextResult = getEncyclopediasByTypeByTextResult;
    }

    @JsonProperty("getEncyclopediasByTypeByTextResult")
    public List<GetEncyclopediasByTypeByTextResult> getGetEncyclopediasByTypeByTextResult() {
        return getEncyclopediasByTypeByTextResult;
    }

    @JsonProperty("getEncyclopediasByTypeByTextResult")
    public void setGetEncyclopediasByTypeByTextResult(List<GetEncyclopediasByTypeByTextResult> getEncyclopediasByTypeByTextResult) {
        this.getEncyclopediasByTypeByTextResult = getEncyclopediasByTypeByTextResult;
    }

    public EncyclopediaTest withGetEncyclopediasByTypeByTextResult(List<GetEncyclopediasByTypeByTextResult> getEncyclopediasByTypeByTextResult) {
        this.getEncyclopediasByTypeByTextResult = getEncyclopediasByTypeByTextResult;
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

    public EncyclopediaTest withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
