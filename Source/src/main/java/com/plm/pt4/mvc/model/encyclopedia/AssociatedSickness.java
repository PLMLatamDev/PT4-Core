
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
    "Active",
    "SicknessId",
    "SicknessName"
})
public class AssociatedSickness {

    @JsonProperty("Active")
    private boolean active;
    @JsonProperty("SicknessId")
    private long sicknessId;
    @JsonProperty("SicknessName")
    private String sicknessName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AssociatedSickness() {
    }

    /**
     * 
     * @param sicknessName
     * @param active
     * @param sicknessId
     */
    public AssociatedSickness(boolean active, long sicknessId, String sicknessName) {
        super();
        this.active = active;
        this.sicknessId = sicknessId;
        this.sicknessName = sicknessName;
    }

    @JsonProperty("Active")
    public boolean isActive() {
        return active;
    }

    @JsonProperty("Active")
    public void setActive(boolean active) {
        this.active = active;
    }

    public AssociatedSickness withActive(boolean active) {
        this.active = active;
        return this;
    }

    @JsonProperty("SicknessId")
    public long getSicknessId() {
        return sicknessId;
    }

    @JsonProperty("SicknessId")
    public void setSicknessId(long sicknessId) {
        this.sicknessId = sicknessId;
    }

    public AssociatedSickness withSicknessId(long sicknessId) {
        this.sicknessId = sicknessId;
        return this;
    }

    @JsonProperty("SicknessName")
    public String getSicknessName() {
        return sicknessName;
    }

    @JsonProperty("SicknessName")
    public void setSicknessName(String sicknessName) {
        this.sicknessName = sicknessName;
    }

    public AssociatedSickness withSicknessName(String sicknessName) {
        this.sicknessName = sicknessName;
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

    public AssociatedSickness withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
