
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
    "AttributeGroupId",
    "AttributeGroupKey",
    "AttributeGroupName",
    "AttributeId",
    "AttributeName",
    "AttributeTypeId",
    "BaseUrl",
    "Content",
    "EncyclopediaId",
    "ImageFile"
})
public class Attribute {

    @JsonProperty("AttributeGroupId")
    private long attributeGroupId;
    @JsonProperty("AttributeGroupKey")
    private String attributeGroupKey;
    @JsonProperty("AttributeGroupName")
    private String attributeGroupName;
    @JsonProperty("AttributeId")
    private long attributeId;
    @JsonProperty("AttributeName")
    private String attributeName;
    @JsonProperty("AttributeTypeId")
    private long attributeTypeId;
    @JsonProperty("BaseUrl")
    private String baseUrl;
    @JsonProperty("Content")
    private String content;
    @JsonProperty("EncyclopediaId")
    private long encyclopediaId;
    @JsonProperty("ImageFile")
    private String imageFile;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Attribute() {
    }

    /**
     * 
     * @param content
     * @param baseUrl
     * @param attributeName
     * @param attributeGroupKey
     * @param attributeTypeId
     * @param imageFile
     * @param attributeGroupName
     * @param attributeId
     * @param encyclopediaId
     * @param attributeGroupId
     */
    public Attribute(long attributeGroupId, String attributeGroupKey, String attributeGroupName, long attributeId, String attributeName, long attributeTypeId, String baseUrl, String content, long encyclopediaId, String imageFile) {
        super();
        this.attributeGroupId = attributeGroupId;
        this.attributeGroupKey = attributeGroupKey;
        this.attributeGroupName = attributeGroupName;
        this.attributeId = attributeId;
        this.attributeName = attributeName;
        this.attributeTypeId = attributeTypeId;
        this.baseUrl = baseUrl;
        this.content = content;
        this.encyclopediaId = encyclopediaId;
        this.imageFile = imageFile;
    }

    @JsonProperty("AttributeGroupId")
    public long getAttributeGroupId() {
        return attributeGroupId;
    }

    @JsonProperty("AttributeGroupId")
    public void setAttributeGroupId(long attributeGroupId) {
        this.attributeGroupId = attributeGroupId;
    }

    public Attribute withAttributeGroupId(long attributeGroupId) {
        this.attributeGroupId = attributeGroupId;
        return this;
    }

    @JsonProperty("AttributeGroupKey")
    public String getAttributeGroupKey() {
        return attributeGroupKey;
    }

    @JsonProperty("AttributeGroupKey")
    public void setAttributeGroupKey(String attributeGroupKey) {
        this.attributeGroupKey = attributeGroupKey;
    }

    public Attribute withAttributeGroupKey(String attributeGroupKey) {
        this.attributeGroupKey = attributeGroupKey;
        return this;
    }

    @JsonProperty("AttributeGroupName")
    public String getAttributeGroupName() {
        return attributeGroupName;
    }

    @JsonProperty("AttributeGroupName")
    public void setAttributeGroupName(String attributeGroupName) {
        this.attributeGroupName = attributeGroupName;
    }

    public Attribute withAttributeGroupName(String attributeGroupName) {
        this.attributeGroupName = attributeGroupName;
        return this;
    }

    @JsonProperty("AttributeId")
    public long getAttributeId() {
        return attributeId;
    }

    @JsonProperty("AttributeId")
    public void setAttributeId(long attributeId) {
        this.attributeId = attributeId;
    }

    public Attribute withAttributeId(long attributeId) {
        this.attributeId = attributeId;
        return this;
    }

    @JsonProperty("AttributeName")
    public String getAttributeName() {
        return attributeName;
    }

    @JsonProperty("AttributeName")
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public Attribute withAttributeName(String attributeName) {
        this.attributeName = attributeName;
        return this;
    }

    @JsonProperty("AttributeTypeId")
    public long getAttributeTypeId() {
        return attributeTypeId;
    }

    @JsonProperty("AttributeTypeId")
    public void setAttributeTypeId(long attributeTypeId) {
        this.attributeTypeId = attributeTypeId;
    }

    public Attribute withAttributeTypeId(long attributeTypeId) {
        this.attributeTypeId = attributeTypeId;
        return this;
    }

    @JsonProperty("BaseUrl")
    public String getBaseUrl() {
        return baseUrl;
    }

    @JsonProperty("BaseUrl")
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Attribute withBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    @JsonProperty("Content")
    public String getContent() {
        return content;
    }

    @JsonProperty("Content")
    public void setContent(String content) {
        this.content = content;
    }

    public Attribute withContent(String content) {
        this.content = content;
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

    public Attribute withEncyclopediaId(long encyclopediaId) {
        this.encyclopediaId = encyclopediaId;
        return this;
    }

    @JsonProperty("ImageFile")
    public String getImageFile() {
        return imageFile;
    }

    @JsonProperty("ImageFile")
    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public Attribute withImageFile(String imageFile) {
        this.imageFile = imageFile;
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

    public Attribute withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
