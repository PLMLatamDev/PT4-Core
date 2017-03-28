
package com.plm.pt4.mvc.model;

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
    "Active",
    "EncyclopediaId",
    "EncyclopediaName",
    "EncyclopediaTypeId",
    "PLMCode"
})
public class GetEncyclopediasByTypeByTextResult {

    @JsonProperty("Active")
    private boolean active;
    @JsonProperty("EncyclopediaId")
    private long encyclopediaId;
    @JsonProperty("EncyclopediaName")
    private String encyclopediaName;
    @JsonProperty("EncyclopediaTypeId")
    private long encyclopediaTypeId;
    @JsonProperty("PLMCode")
    private String pLMCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GetEncyclopediasByTypeByTextResult() {
    }

    /**
     * 
     * @param encyclopediaTypeId
     * @param active
     * @param pLMCode
     * @param encyclopediaName
     * @param encyclopediaId
     */
    public GetEncyclopediasByTypeByTextResult(boolean active, long encyclopediaId, String encyclopediaName, long encyclopediaTypeId, String pLMCode) {
        super();
        this.active = active;
        this.encyclopediaId = encyclopediaId;
        this.encyclopediaName = encyclopediaName;
        this.encyclopediaTypeId = encyclopediaTypeId;
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

    public GetEncyclopediasByTypeByTextResult withActive(boolean active) {
        this.active = active;
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

    public GetEncyclopediasByTypeByTextResult withEncyclopediaId(long encyclopediaId) {
        this.encyclopediaId = encyclopediaId;
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

    public GetEncyclopediasByTypeByTextResult withEncyclopediaName(String encyclopediaName) {
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

    public GetEncyclopediasByTypeByTextResult withEncyclopediaTypeId(long encyclopediaTypeId) {
        this.encyclopediaTypeId = encyclopediaTypeId;
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

    public GetEncyclopediasByTypeByTextResult withPLMCode(String pLMCode) {
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

    public GetEncyclopediasByTypeByTextResult withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
