
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
    "AddedDate",
    "AddressId",
    "Age",
    "Birthday",
    "ClientDistance",
    "ClientId",
    "CompleteName",
    "CountryId",
    "CountryName",
    "DisplayClients",
    "Email",
    "Ext",
    "ExternalNumber",
    "FirstName",
    "Gender",
    "InternalNumber",
    "Lada",
    "LastName",
    "LastUpdate",
    "Latitude",
    "LocationId",
    "LocationName",
    "Longitude",
    "Mobile",
    "Password",
    "PhoneOne",
    "PhoneTwo",
    "ProfessionId",
    "ProfessionName",
    "SecondLastName",
    "SpecialityId",
    "SpecialityName",
    "StateId",
    "StateName",
    "Street",
    "SuburbId",
    "SuburbName",
    "ZipCode",
    "ZipCodeId"
})
public class MedicalClient {

    @JsonProperty("AddedDate")
    private String addedDate;
    @JsonProperty("AddressId")
    private long addressId;
    @JsonProperty("Age")
    private Object age;
    @JsonProperty("Birthday")
    private Object birthday;
    @JsonProperty("ClientDistance")
    private Object clientDistance;
    @JsonProperty("ClientId")
    private long clientId;
    @JsonProperty("CompleteName")
    private String completeName;
    @JsonProperty("CountryId")
    private long countryId;
    @JsonProperty("CountryName")
    private String countryName;
    @JsonProperty("DisplayClients")
    private Object displayClients;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("Ext")
    private Object ext;
    @JsonProperty("ExternalNumber")
    private Object externalNumber;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("Gender")
    private String gender;
    @JsonProperty("InternalNumber")
    private Object internalNumber;
    @JsonProperty("Lada")
    private Object lada;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("LastUpdate")
    private String lastUpdate;
    @JsonProperty("Latitude")
    private double latitude;
    @JsonProperty("LocationId")
    private long locationId;
    @JsonProperty("LocationName")
    private String locationName;
    @JsonProperty("Longitude")
    private double longitude;
    @JsonProperty("Mobile")
    private String mobile;
    @JsonProperty("Password")
    private Object password;
    @JsonProperty("PhoneOne")
    private String phoneOne;
    @JsonProperty("PhoneTwo")
    private Object phoneTwo;
    @JsonProperty("ProfessionId")
    private long professionId;
    @JsonProperty("ProfessionName")
    private String professionName;
    @JsonProperty("SecondLastName")
    private String secondLastName;
    @JsonProperty("SpecialityId")
    private long specialityId;
    @JsonProperty("SpecialityName")
    private String specialityName;
    @JsonProperty("StateId")
    private long stateId;
    @JsonProperty("StateName")
    private String stateName;
    @JsonProperty("Street")
    private String street;
    @JsonProperty("SuburbId")
    private long suburbId;
    @JsonProperty("SuburbName")
    private String suburbName;
    @JsonProperty("ZipCode")
    private String zipCode;
    @JsonProperty("ZipCodeId")
    private long zipCodeId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public MedicalClient() {
    }

    /**
     * 
     * @param birthday
     * @param countryName
     * @param lada
     * @param lastUpdate
     * @param street
     * @param clientDistance
     * @param locationId
     * @param locationName
     * @param password
     * @param specialityName
     * @param phoneTwo
     * @param ext
     * @param addressId
     * @param suburbId
     * @param zipCodeId
     * @param zipCode
     * @param completeName
     * @param age
     * @param specialityId
     * @param displayClients
     * @param gender
     * @param longitude
     * @param firstName
     * @param countryId
     * @param addedDate
     * @param lastName
     * @param internalNumber
     * @param professionId
     * @param secondLastName
     * @param suburbName
     * @param clientId
     * @param email
     * @param stateId
     * @param stateName
     * @param externalNumber
     * @param phoneOne
     * @param latitude
     * @param professionName
     * @param mobile
     */
    public MedicalClient(String addedDate, long addressId, Object age, Object birthday, Object clientDistance, long clientId, String completeName, long countryId, String countryName, Object displayClients, String email, Object ext, Object externalNumber, String firstName, String gender, Object internalNumber, Object lada, String lastName, String lastUpdate, double latitude, long locationId, String locationName, double longitude, String mobile, Object password, String phoneOne, Object phoneTwo, long professionId, String professionName, String secondLastName, long specialityId, String specialityName, long stateId, String stateName, String street, long suburbId, String suburbName, String zipCode, long zipCodeId) {
        super();
        this.addedDate = addedDate;
        this.addressId = addressId;
        this.age = age;
        this.birthday = birthday;
        this.clientDistance = clientDistance;
        this.clientId = clientId;
        this.completeName = completeName;
        this.countryId = countryId;
        this.countryName = countryName;
        this.displayClients = displayClients;
        this.email = email;
        this.ext = ext;
        this.externalNumber = externalNumber;
        this.firstName = firstName;
        this.gender = gender;
        this.internalNumber = internalNumber;
        this.lada = lada;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
        this.latitude = latitude;
        this.locationId = locationId;
        this.locationName = locationName;
        this.longitude = longitude;
        this.mobile = mobile;
        this.password = password;
        this.phoneOne = phoneOne;
        this.phoneTwo = phoneTwo;
        this.professionId = professionId;
        this.professionName = professionName;
        this.secondLastName = secondLastName;
        this.specialityId = specialityId;
        this.specialityName = specialityName;
        this.stateId = stateId;
        this.stateName = stateName;
        this.street = street;
        this.suburbId = suburbId;
        this.suburbName = suburbName;
        this.zipCode = zipCode;
        this.zipCodeId = zipCodeId;
    }

    @JsonProperty("AddedDate")
    public String getAddedDate() {
        return addedDate;
    }

    @JsonProperty("AddedDate")
    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    public MedicalClient withAddedDate(String addedDate) {
        this.addedDate = addedDate;
        return this;
    }

    @JsonProperty("AddressId")
    public long getAddressId() {
        return addressId;
    }

    @JsonProperty("AddressId")
    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public MedicalClient withAddressId(long addressId) {
        this.addressId = addressId;
        return this;
    }

    @JsonProperty("Age")
    public Object getAge() {
        return age;
    }

    @JsonProperty("Age")
    public void setAge(Object age) {
        this.age = age;
    }

    public MedicalClient withAge(Object age) {
        this.age = age;
        return this;
    }

    @JsonProperty("Birthday")
    public Object getBirthday() {
        return birthday;
    }

    @JsonProperty("Birthday")
    public void setBirthday(Object birthday) {
        this.birthday = birthday;
    }

    public MedicalClient withBirthday(Object birthday) {
        this.birthday = birthday;
        return this;
    }

    @JsonProperty("ClientDistance")
    public Object getClientDistance() {
        return clientDistance;
    }

    @JsonProperty("ClientDistance")
    public void setClientDistance(Object clientDistance) {
        this.clientDistance = clientDistance;
    }

    public MedicalClient withClientDistance(Object clientDistance) {
        this.clientDistance = clientDistance;
        return this;
    }

    @JsonProperty("ClientId")
    public long getClientId() {
        return clientId;
    }

    @JsonProperty("ClientId")
    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public MedicalClient withClientId(long clientId) {
        this.clientId = clientId;
        return this;
    }

    @JsonProperty("CompleteName")
    public String getCompleteName() {
        return completeName;
    }

    @JsonProperty("CompleteName")
    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    public MedicalClient withCompleteName(String completeName) {
        this.completeName = completeName;
        return this;
    }

    @JsonProperty("CountryId")
    public long getCountryId() {
        return countryId;
    }

    @JsonProperty("CountryId")
    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public MedicalClient withCountryId(long countryId) {
        this.countryId = countryId;
        return this;
    }

    @JsonProperty("CountryName")
    public String getCountryName() {
        return countryName;
    }

    @JsonProperty("CountryName")
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public MedicalClient withCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    @JsonProperty("DisplayClients")
    public Object getDisplayClients() {
        return displayClients;
    }

    @JsonProperty("DisplayClients")
    public void setDisplayClients(Object displayClients) {
        this.displayClients = displayClients;
    }

    public MedicalClient withDisplayClients(Object displayClients) {
        this.displayClients = displayClients;
        return this;
    }

    @JsonProperty("Email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("Email")
    public void setEmail(String email) {
        this.email = email;
    }

    public MedicalClient withEmail(String email) {
        this.email = email;
        return this;
    }

    @JsonProperty("Ext")
    public Object getExt() {
        return ext;
    }

    @JsonProperty("Ext")
    public void setExt(Object ext) {
        this.ext = ext;
    }

    public MedicalClient withExt(Object ext) {
        this.ext = ext;
        return this;
    }

    @JsonProperty("ExternalNumber")
    public Object getExternalNumber() {
        return externalNumber;
    }

    @JsonProperty("ExternalNumber")
    public void setExternalNumber(Object externalNumber) {
        this.externalNumber = externalNumber;
    }

    public MedicalClient withExternalNumber(Object externalNumber) {
        this.externalNumber = externalNumber;
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

    public MedicalClient withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @JsonProperty("Gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("Gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    public MedicalClient withGender(String gender) {
        this.gender = gender;
        return this;
    }

    @JsonProperty("InternalNumber")
    public Object getInternalNumber() {
        return internalNumber;
    }

    @JsonProperty("InternalNumber")
    public void setInternalNumber(Object internalNumber) {
        this.internalNumber = internalNumber;
    }

    public MedicalClient withInternalNumber(Object internalNumber) {
        this.internalNumber = internalNumber;
        return this;
    }

    @JsonProperty("Lada")
    public Object getLada() {
        return lada;
    }

    @JsonProperty("Lada")
    public void setLada(Object lada) {
        this.lada = lada;
    }

    public MedicalClient withLada(Object lada) {
        this.lada = lada;
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

    public MedicalClient withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @JsonProperty("LastUpdate")
    public String getLastUpdate() {
        return lastUpdate;
    }

    @JsonProperty("LastUpdate")
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public MedicalClient withLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    @JsonProperty("Latitude")
    public double getLatitude() {
        return latitude;
    }

    @JsonProperty("Latitude")
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public MedicalClient withLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    @JsonProperty("LocationId")
    public long getLocationId() {
        return locationId;
    }

    @JsonProperty("LocationId")
    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public MedicalClient withLocationId(long locationId) {
        this.locationId = locationId;
        return this;
    }

    @JsonProperty("LocationName")
    public String getLocationName() {
        return locationName;
    }

    @JsonProperty("LocationName")
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public MedicalClient withLocationName(String locationName) {
        this.locationName = locationName;
        return this;
    }

    @JsonProperty("Longitude")
    public double getLongitude() {
        return longitude;
    }

    @JsonProperty("Longitude")
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public MedicalClient withLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }

    @JsonProperty("Mobile")
    public String getMobile() {
        return mobile;
    }

    @JsonProperty("Mobile")
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public MedicalClient withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    @JsonProperty("Password")
    public Object getPassword() {
        return password;
    }

    @JsonProperty("Password")
    public void setPassword(Object password) {
        this.password = password;
    }

    public MedicalClient withPassword(Object password) {
        this.password = password;
        return this;
    }

    @JsonProperty("PhoneOne")
    public String getPhoneOne() {
        return phoneOne;
    }

    @JsonProperty("PhoneOne")
    public void setPhoneOne(String phoneOne) {
        this.phoneOne = phoneOne;
    }

    public MedicalClient withPhoneOne(String phoneOne) {
        this.phoneOne = phoneOne;
        return this;
    }

    @JsonProperty("PhoneTwo")
    public Object getPhoneTwo() {
        return phoneTwo;
    }

    @JsonProperty("PhoneTwo")
    public void setPhoneTwo(Object phoneTwo) {
        this.phoneTwo = phoneTwo;
    }

    public MedicalClient withPhoneTwo(Object phoneTwo) {
        this.phoneTwo = phoneTwo;
        return this;
    }

    @JsonProperty("ProfessionId")
    public long getProfessionId() {
        return professionId;
    }

    @JsonProperty("ProfessionId")
    public void setProfessionId(long professionId) {
        this.professionId = professionId;
    }

    public MedicalClient withProfessionId(long professionId) {
        this.professionId = professionId;
        return this;
    }

    @JsonProperty("ProfessionName")
    public String getProfessionName() {
        return professionName;
    }

    @JsonProperty("ProfessionName")
    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public MedicalClient withProfessionName(String professionName) {
        this.professionName = professionName;
        return this;
    }

    @JsonProperty("SecondLastName")
    public String getSecondLastName() {
        return secondLastName;
    }

    @JsonProperty("SecondLastName")
    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public MedicalClient withSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
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

    public MedicalClient withSpecialityId(long specialityId) {
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

    public MedicalClient withSpecialityName(String specialityName) {
        this.specialityName = specialityName;
        return this;
    }

    @JsonProperty("StateId")
    public long getStateId() {
        return stateId;
    }

    @JsonProperty("StateId")
    public void setStateId(long stateId) {
        this.stateId = stateId;
    }

    public MedicalClient withStateId(long stateId) {
        this.stateId = stateId;
        return this;
    }

    @JsonProperty("StateName")
    public String getStateName() {
        return stateName;
    }

    @JsonProperty("StateName")
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public MedicalClient withStateName(String stateName) {
        this.stateName = stateName;
        return this;
    }

    @JsonProperty("Street")
    public String getStreet() {
        return street;
    }

    @JsonProperty("Street")
    public void setStreet(String street) {
        this.street = street;
    }

    public MedicalClient withStreet(String street) {
        this.street = street;
        return this;
    }

    @JsonProperty("SuburbId")
    public long getSuburbId() {
        return suburbId;
    }

    @JsonProperty("SuburbId")
    public void setSuburbId(long suburbId) {
        this.suburbId = suburbId;
    }

    public MedicalClient withSuburbId(long suburbId) {
        this.suburbId = suburbId;
        return this;
    }

    @JsonProperty("SuburbName")
    public String getSuburbName() {
        return suburbName;
    }

    @JsonProperty("SuburbName")
    public void setSuburbName(String suburbName) {
        this.suburbName = suburbName;
    }

    public MedicalClient withSuburbName(String suburbName) {
        this.suburbName = suburbName;
        return this;
    }

    @JsonProperty("ZipCode")
    public String getZipCode() {
        return zipCode;
    }

    @JsonProperty("ZipCode")
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public MedicalClient withZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    @JsonProperty("ZipCodeId")
    public long getZipCodeId() {
        return zipCodeId;
    }

    @JsonProperty("ZipCodeId")
    public void setZipCodeId(long zipCodeId) {
        this.zipCodeId = zipCodeId;
    }

    public MedicalClient withZipCodeId(long zipCodeId) {
        this.zipCodeId = zipCodeId;
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

    public MedicalClient withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
