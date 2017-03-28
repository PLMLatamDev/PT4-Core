
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
    "Active",
    "CodeId",
    "CodeString",
    "CompanyClientId",
    "CompanyUserId",
    "FirstName",
    "LastName",
    "UserName",
    "UserPassword"
})
public class GetPharmacyUserResult {

    @JsonProperty("Active")
    private boolean active;
    @JsonProperty("CodeId")
    private long codeId;
    @JsonProperty("CodeString")
    private String codeString;
    @JsonProperty("CompanyClientId")
    private long companyClientId;
    @JsonProperty("CompanyUserId")
    private long companyUserId;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("UserName")
    private String userName;
    @JsonProperty("UserPassword")
    private String userPassword;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GetPharmacyUserResult() {
    }

    /**
     * 
     * @param lastName
     * @param codeId
     * @param userPassword
     * @param codeString
     * @param userName
     * @param active
     * @param companyClientId
     * @param firstName
     * @param companyUserId
     */
    public GetPharmacyUserResult(boolean active, long codeId, String codeString, long companyClientId, long companyUserId, String firstName, String lastName, String userName, String userPassword) {
        super();
        this.active = active;
        this.codeId = codeId;
        this.codeString = codeString;
        this.companyClientId = companyClientId;
        this.companyUserId = companyUserId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    @JsonProperty("Active")
    public boolean isActive() {
        return active;
    }

    @JsonProperty("Active")
    public void setActive(boolean active) {
        this.active = active;
    }

    public GetPharmacyUserResult withActive(boolean active) {
        this.active = active;
        return this;
    }

    @JsonProperty("CodeId")
    public long getCodeId() {
        return codeId;
    }

    @JsonProperty("CodeId")
    public void setCodeId(long codeId) {
        this.codeId = codeId;
    }

    public GetPharmacyUserResult withCodeId(long codeId) {
        this.codeId = codeId;
        return this;
    }

    @JsonProperty("CodeString")
    public String getCodeString() {
        return codeString;
    }

    @JsonProperty("CodeString")
    public void setCodeString(String codeString) {
        this.codeString = codeString;
    }

    public GetPharmacyUserResult withCodeString(String codeString) {
        this.codeString = codeString;
        return this;
    }

    @JsonProperty("CompanyClientId")
    public long getCompanyClientId() {
        return companyClientId;
    }

    @JsonProperty("CompanyClientId")
    public void setCompanyClientId(long companyClientId) {
        this.companyClientId = companyClientId;
    }

    public GetPharmacyUserResult withCompanyClientId(long companyClientId) {
        this.companyClientId = companyClientId;
        return this;
    }

    @JsonProperty("CompanyUserId")
    public long getCompanyUserId() {
        return companyUserId;
    }

    @JsonProperty("CompanyUserId")
    public void setCompanyUserId(long companyUserId) {
        this.companyUserId = companyUserId;
    }

    public GetPharmacyUserResult withCompanyUserId(long companyUserId) {
        this.companyUserId = companyUserId;
        return this;
    }

    @JsonProperty("FirstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("FirstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public GetPharmacyUserResult withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @JsonProperty("LastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("LastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public GetPharmacyUserResult withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @JsonProperty("UserName")
    public String getUserName() {
        return userName;
    }

    @JsonProperty("UserName")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public GetPharmacyUserResult withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    @JsonProperty("UserPassword")
    public String getUserPassword() {
        return userPassword;
    }

    @JsonProperty("UserPassword")
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public GetPharmacyUserResult withUserPassword(String userPassword) {
        this.userPassword = userPassword;
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

    public GetPharmacyUserResult withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
