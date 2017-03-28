
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
    "MedicalClient",
    "ShortName",
    "SpecialityId",
    "SpecialityName"
})
public class MedicalSpeciality {

    @JsonProperty("Active")
    private boolean active;
    @JsonProperty("MedicalClient")
    private List<MedicalClient> medicalClient = null;
    @JsonProperty("ShortName")
    private Object shortName;
    @JsonProperty("SpecialityId")
    private long specialityId;
    @JsonProperty("SpecialityName")
    private String specialityName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public MedicalSpeciality() {
    }

    /**
     * 
     * @param specialityId
     * @param active
     * @param shortName
     * @param medicalClient
     * @param specialityName
     */
    public MedicalSpeciality(boolean active, List<MedicalClient> medicalClient, Object shortName, long specialityId, String specialityName) {
        super();
        this.active = active;
        this.medicalClient = medicalClient;
        this.shortName = shortName;
        this.specialityId = specialityId;
        this.specialityName = specialityName;
    }

    @JsonProperty("Active")
    public boolean isActive() {
        return active;
    }

    @JsonProperty("Active")
    public void setActive(boolean active) {
        this.active = active;
    }

    public MedicalSpeciality withActive(boolean active) {
        this.active = active;
        return this;
    }

    @JsonProperty("MedicalClient")
    public List<MedicalClient> getMedicalClient() {
        return medicalClient;
    }

    @JsonProperty("MedicalClient")
    public void setMedicalClient(List<MedicalClient> medicalClient) {
        this.medicalClient = medicalClient;
    }

    public MedicalSpeciality withMedicalClient(List<MedicalClient> medicalClient) {
        this.medicalClient = medicalClient;
        return this;
    }

    @JsonProperty("ShortName")
    public Object getShortName() {
        return shortName;
    }

    @JsonProperty("ShortName")
    public void setShortName(Object shortName) {
        this.shortName = shortName;
    }

    public MedicalSpeciality withShortName(Object shortName) {
        this.shortName = shortName;
        return this;
    }

    @JsonProperty("SpecialityId")
    public long getSpecialityId() {
        return specialityId;
    }

    @JsonProperty("SpecialityId")
    public void setSpecialityId(long specialityId) {
        this.specialityId = specialityId;
    }

    public MedicalSpeciality withSpecialityId(long specialityId) {
        this.specialityId = specialityId;
        return this;
    }

    @JsonProperty("SpecialityName")
    public String getSpecialityName() {
        return specialityName;
    }

    @JsonProperty("SpecialityName")
    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    public MedicalSpeciality withSpecialityName(String specialityName) {
        this.specialityName = specialityName;
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

    public MedicalSpeciality withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
