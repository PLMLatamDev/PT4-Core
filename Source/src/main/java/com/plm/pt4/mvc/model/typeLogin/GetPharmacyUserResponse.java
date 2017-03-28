
package com.plm.pt4.mvc.model.typeLogin;

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
    "getPharmacyUserResult"
})
public class GetPharmacyUserResponse {

    @JsonProperty("getPharmacyUserResult")
    private GetPharmacyUserResult getPharmacyUserResult;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GetPharmacyUserResponse() {
    }

    /**
     * 
     * @param getPharmacyUserResult
     */
    public GetPharmacyUserResponse(GetPharmacyUserResult getPharmacyUserResult) {
        super();
        this.getPharmacyUserResult = getPharmacyUserResult;
    }

    @JsonProperty("getPharmacyUserResult")
    public GetPharmacyUserResult getGetPharmacyUserResult() {
        return getPharmacyUserResult;
    }

    @JsonProperty("getPharmacyUserResult")
    public void setGetPharmacyUserResult(GetPharmacyUserResult getPharmacyUserResult) {
        this.getPharmacyUserResult = getPharmacyUserResult;
    }

    public GetPharmacyUserResponse withGetPharmacyUserResult(GetPharmacyUserResult getPharmacyUserResult) {
        this.getPharmacyUserResult = getPharmacyUserResult;
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

    public GetPharmacyUserResponse withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
