
package com.plm.pt4.mvc.model;

import java.util.HashMap;
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
    "Active",
    "ActiveSubstanceId",
    "Description",
    "EnglishDescription",
    "Enunciative",
    "JSONFormat",
    "SubstanceKey",
    "$$hashKey"
})
public class SubstanceByMedicalPrescription {

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
    @JsonProperty("$$hashKey")
    private String $$hashKey;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SubstanceByMedicalPrescription() {
    }

    /**
     * 
     * @param $$hashKey
     * @param activeSubstanceId
     * @param description
     * @param jSONFormat
     * @param englishDescription
     * @param active
     * @param substanceKey
     * @param enunciative
     */
    public SubstanceByMedicalPrescription(boolean active, long activeSubstanceId, String description, String englishDescription, boolean enunciative, String jSONFormat, String substanceKey, String $$hashKey) {
        this.active = active;
        this.activeSubstanceId = activeSubstanceId;
        this.description = description;
        this.englishDescription = englishDescription;
        this.enunciative = enunciative;
        this.jSONFormat = jSONFormat;
        this.substanceKey = substanceKey;
        this.$$hashKey = $$hashKey;
    }

    /**
     * 
     * @return
     *     The active
     */
    @JsonProperty("Active")
    public boolean isActive() {
        return active;
    }

    /**
     * 
     * @param active
     *     The Active
     */
    @JsonProperty("Active")
    public void setActive(boolean active) {
        this.active = active;
    }

    public SubstanceByMedicalPrescription withActive(boolean active) {
        this.active = active;
        return this;
    }

    /**
     * 
     * @return
     *     The activeSubstanceId
     */
    @JsonProperty("ActiveSubstanceId")
    public long getActiveSubstanceId() {
        return activeSubstanceId;
    }

    /**
     * 
     * @param activeSubstanceId
     *     The ActiveSubstanceId
     */
    @JsonProperty("ActiveSubstanceId")
    public void setActiveSubstanceId(long activeSubstanceId) {
        this.activeSubstanceId = activeSubstanceId;
    }

    public SubstanceByMedicalPrescription withActiveSubstanceId(long activeSubstanceId) {
        this.activeSubstanceId = activeSubstanceId;
        return this;
    }

    /**
     * 
     * @return
     *     The description
     */
    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The Description
     */
    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    public SubstanceByMedicalPrescription withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * 
     * @return
     *     The englishDescription
     */
    @JsonProperty("EnglishDescription")
    public String getEnglishDescription() {
        return englishDescription;
    }

    /**
     * 
     * @param englishDescription
     *     The EnglishDescription
     */
    @JsonProperty("EnglishDescription")
    public void setEnglishDescription(String englishDescription) {
        this.englishDescription = englishDescription;
    }

    public SubstanceByMedicalPrescription withEnglishDescription(String englishDescription) {
        this.englishDescription = englishDescription;
        return this;
    }

    /**
     * 
     * @return
     *     The enunciative
     */
    @JsonProperty("Enunciative")
    public boolean isEnunciative() {
        return enunciative;
    }

    /**
     * 
     * @param enunciative
     *     The Enunciative
     */
    @JsonProperty("Enunciative")
    public void setEnunciative(boolean enunciative) {
        this.enunciative = enunciative;
    }

    public SubstanceByMedicalPrescription withEnunciative(boolean enunciative) {
        this.enunciative = enunciative;
        return this;
    }

    /**
     * 
     * @return
     *     The jSONFormat
     */
    @JsonProperty("JSONFormat")
    public String getJSONFormat() {
        return jSONFormat;
    }

    /**
     * 
     * @param jSONFormat
     *     The JSONFormat
     */
    @JsonProperty("JSONFormat")
    public void setJSONFormat(String jSONFormat) {
        this.jSONFormat = jSONFormat;
    }

    public SubstanceByMedicalPrescription withJSONFormat(String jSONFormat) {
        this.jSONFormat = jSONFormat;
        return this;
    }

    /**
     * 
     * @return
     *     The substanceKey
     */
    @JsonProperty("SubstanceKey")
    public String getSubstanceKey() {
        return substanceKey;
    }

    /**
     * 
     * @param substanceKey
     *     The SubstanceKey
     */
    @JsonProperty("SubstanceKey")
    public void setSubstanceKey(String substanceKey) {
        this.substanceKey = substanceKey;
    }

    public SubstanceByMedicalPrescription withSubstanceKey(String substanceKey) {
        this.substanceKey = substanceKey;
        return this;
    }

    /**
     * 
     * @return
     *     The $$hashKey
     */
    @JsonProperty("$$hashKey")
    public String get$$hashKey() {
        return $$hashKey;
    }

    /**
     * 
     * @param $$hashKey
     *     The $$hashKey
     */
    @JsonProperty("$$hashKey")
    public void set$$hashKey(String $$hashKey) {
        this.$$hashKey = $$hashKey;
    }

    public SubstanceByMedicalPrescription with$$hashKey(String $$hashKey) {
        this.$$hashKey = $$hashKey;
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

    public SubstanceByMedicalPrescription withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
