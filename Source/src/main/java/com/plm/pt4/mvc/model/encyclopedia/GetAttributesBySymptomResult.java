
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
    "AttributeId",
    "AttributeOrder",
    "Content",
    "Description",
    "HeaderImage",
    "PlainContent",
    "SymptomName"
})
public class GetAttributesBySymptomResult {

    @JsonProperty("AttributeId")
    private long attributeId;
    @JsonProperty("AttributeOrder")
    private long attributeOrder;
    @JsonProperty("Content")
    private String content;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("HeaderImage")
    private String headerImage;
    @JsonProperty("PlainContent")
    private String plainContent;
    @JsonProperty("SymptomName")
    private String symptomName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GetAttributesBySymptomResult() {
    }

    /**
     * 
     * @param content
     * @param symptomName
     * @param headerImage
     * @param plainContent
     * @param description
     * @param attributeOrder
     * @param attributeId
     */
    public GetAttributesBySymptomResult(long attributeId, long attributeOrder, String content, String description, String headerImage, String plainContent, String symptomName) {
        super();
        this.attributeId = attributeId;
        this.attributeOrder = attributeOrder;
        this.content = content;
        this.description = description;
        this.headerImage = headerImage;
        this.plainContent = plainContent;
        this.symptomName = symptomName;
    }

    @JsonProperty("AttributeId")
    public long getAttributeId() {
        return attributeId;
    }

    @JsonProperty("AttributeId")
    public void setAttributeId(long attributeId) {
        this.attributeId = attributeId;
    }

    public GetAttributesBySymptomResult withAttributeId(long attributeId) {
        this.attributeId = attributeId;
        return this;
    }

    @JsonProperty("AttributeOrder")
    public long getAttributeOrder() {
        return attributeOrder;
    }

    @JsonProperty("AttributeOrder")
    public void setAttributeOrder(long attributeOrder) {
        this.attributeOrder = attributeOrder;
    }

    public GetAttributesBySymptomResult withAttributeOrder(long attributeOrder) {
        this.attributeOrder = attributeOrder;
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

    public GetAttributesBySymptomResult withContent(String content) {
        this.content = content;
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

    public GetAttributesBySymptomResult withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("HeaderImage")
    public String getHeaderImage() {
        return headerImage;
    }

    @JsonProperty("HeaderImage")
    public void setHeaderImage(String headerImage) {
        this.headerImage = headerImage;
    }

    public GetAttributesBySymptomResult withHeaderImage(String headerImage) {
        this.headerImage = headerImage;
        return this;
    }

    @JsonProperty("PlainContent")
    public String getPlainContent() {
        return plainContent;
    }

    @JsonProperty("PlainContent")
    public void setPlainContent(String plainContent) {
        this.plainContent = plainContent;
    }

    public GetAttributesBySymptomResult withPlainContent(String plainContent) {
        this.plainContent = plainContent;
        return this;
    }

    @JsonProperty("SymptomName")
    public String getSymptomName() {
        return symptomName;
    }

    @JsonProperty("SymptomName")
    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName;
    }

    public GetAttributesBySymptomResult withSymptomName(String symptomName) {
        this.symptomName = symptomName;
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

    public GetAttributesBySymptomResult withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
