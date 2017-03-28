
package com.plm.pt4.mvc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "categoryName",
    "showBycategory",
    "categoryActive",
    "categoryId",
    "categotyPath",
    "calculators"
})
public class CalculatorsByCategory {

    @JsonProperty("categoryName")
    private String categoryName;
    @JsonProperty("showBycategory")
    private boolean showBycategory;
    @JsonProperty("categoryActive")
    private boolean categoryActive;
    @JsonProperty("categoryId")
    private long categoryId;
    @JsonProperty("categotyPath")
    private String categotyPath;
    @JsonProperty("calculators")
    private List<Calculator> calculators = new ArrayList<Calculator>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CalculatorsByCategory() {
    }

    /**
     * 
     * @param categoryName
     * @param categoryActive
     * @param showBycategory
     * @param categoryId
     * @param categotyPath
     * @param calculators
     */
    public CalculatorsByCategory(String categoryName, boolean showBycategory, boolean categoryActive, long categoryId, String categotyPath, List<Calculator> calculators) {
        this.categoryName = categoryName;
        this.showBycategory = showBycategory;
        this.categoryActive = categoryActive;
        this.categoryId = categoryId;
        this.categotyPath = categotyPath;
        this.calculators = calculators;
    }

    /**
     * 
     * @return
     *     The categoryName
     */
    @JsonProperty("categoryName")
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 
     * @param categoryName
     *     The categoryName
     */
    @JsonProperty("categoryName")
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * 
     * @return
     *     The showBycategory
     */
    @JsonProperty("showBycategory")
    public boolean isShowBycategory() {
        return showBycategory;
    }

    /**
     * 
     * @param showBycategory
     *     The showBycategory
     */
    @JsonProperty("showBycategory")
    public void setShowBycategory(boolean showBycategory) {
        this.showBycategory = showBycategory;
    }

    /**
     * 
     * @return
     *     The categoryActive
     */
    @JsonProperty("categoryActive")
    public boolean isCategoryActive() {
        return categoryActive;
    }

    /**
     * 
     * @param categoryActive
     *     The categoryActive
     */
    @JsonProperty("categoryActive")
    public void setCategoryActive(boolean categoryActive) {
        this.categoryActive = categoryActive;
    }

    /**
     * 
     * @return
     *     The categoryId
     */
    @JsonProperty("categoryId")
    public long getCategoryId() {
        return categoryId;
    }

    /**
     * 
     * @param categoryId
     *     The categoryId
     */
    @JsonProperty("categoryId")
    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 
     * @return
     *     The categotyPath
     */
    @JsonProperty("categotyPath")
    public String getCategotyPath() {
        return categotyPath;
    }

    /**
     * 
     * @param categotyPath
     *     The categotyPath
     */
    @JsonProperty("categotyPath")
    public void setCategotyPath(String categotyPath) {
        this.categotyPath = categotyPath;
    }

    /**
     * 
     * @return
     *     The calculators
     */
    @JsonProperty("calculators")
    public List<Calculator> getCalculators() {
        return calculators;
    }

    /**
     * 
     * @param calculators
     *     The calculators
     */
    @JsonProperty("calculators")
    public void setCalculators(List<Calculator> calculators) {
        this.calculators = calculators;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
