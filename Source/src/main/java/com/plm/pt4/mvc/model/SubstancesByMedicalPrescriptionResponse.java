
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
    "ActiveSubstanceId",
    "Description",
    "EnglishDescription",
    "Enunciative",
    "JSONFormat",
    "SubstanceKey"
})
public class SubstancesByMedicalPrescriptionResponse {

    @JsonProperty("Active")
    private boolean active;
    @JsonProperty("ActiveSubstanceId")
    private long activeSubstanceId;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("EnglishDescription")
    private String englishDescription;
    @JsonProperty("Enunciative")
    private boolean enunciative;
    @JsonProperty("JSONFormat")
    private String jSONFormat;
    @JsonProperty("SubstanceKey")
    private String substanceKey;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SubstancesByMedicalPrescriptionResponse() {
    }

    /**
     * 
     * @param activeSubstanceId
     * @param description
     * @param jSONFormat
     * @param englishDescription
     * @param active
     * @param substanceKey
     * @param enunciative
     */
    public SubstancesByMedicalPrescriptionResponse(boolean active, long activeSubstanceId, String description, String englishDescription, boolean enunciative, String jSONFormat, String substanceKey) {
        super();
        this.active = active;
        this.activeSubstanceId = activeSubstanceId;
        this.description = description;
        this.englishDescription = englishDescription;
        this.enunciative = enunciative;
        this.jSONFormat = jSONFormat;
        this.substanceKey = substanceKey;
    }

    @JsonProperty("Active")
    public boolean isActive() {
        return active;
    }

    @JsonProperty("Active")
    public void setActive(boolean active) {
        this.active = active;
    }

    public SubstancesByMedicalPrescriptionResponse withActive(boolean active) {
        this.active = active;
        return this;
    }

    @JsonProperty("ActiveSubstanceId")
    public long getActiveSubstanceId() {
        return activeSubstanceId;
    }

    @JsonProperty("ActiveSubstanceId")
    public void setActiveSubstanceId(long activeSubstanceId) {
        this.activeSubstanceId = activeSubstanceId;
    }

    public SubstancesByMedicalPrescriptionResponse withActiveSubstanceId(long activeSubstanceId) {
        this.activeSubstanceId = activeSubstanceId;
        return this;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    public SubstancesByMedicalPrescriptionResponse withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("EnglishDescription")
    public String getEnglishDescription() {
        return englishDescription;
    }

    @JsonProperty("EnglishDescription")
    public void setEnglishDescription(String englishDescription) {
        this.englishDescription = englishDescription;
    }

    public SubstancesByMedicalPrescriptionResponse withEnglishDescription(String englishDescription) {
        this.englishDescription = englishDescription;
        return this;
    }

    @JsonProperty("Enunciative")
    public boolean isEnunciative() {
        return enunciative;
    }

    @JsonProperty("Enunciative")
    public void setEnunciative(boolean enunciative) {
        this.enunciative = enunciative;
    }

    public SubstancesByMedicalPrescriptionResponse withEnunciative(boolean enunciative) {
        this.enunciative = enunciative;
        return this;
    }

    @JsonProperty("JSONFormat")
    public String getJSONFormat() {
        return jSONFormat;
    }

    @JsonProperty("JSONFormat")
    public void setJSONFormat(String jSONFormat) {
        this.jSONFormat = jSONFormat;
    }

    public SubstancesByMedicalPrescriptionResponse withJSONFormat(String jSONFormat) {
        this.jSONFormat = jSONFormat;
        return this;
    }

    @JsonProperty("SubstanceKey")
    public String getSubstanceKey() {
        return substanceKey;
    }

    @JsonProperty("SubstanceKey")
    public void setSubstanceKey(String substanceKey) {
        this.substanceKey = substanceKey;
    }

    public SubstancesByMedicalPrescriptionResponse withSubstanceKey(String substanceKey) {
        this.substanceKey = substanceKey;
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

    public SubstancesByMedicalPrescriptionResponse withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
