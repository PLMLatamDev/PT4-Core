package com.plm.pt4.mvc.model.encyclopedia;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeneralEncyclopedias {
	
	@JsonProperty("NameEncyclopedia")
	private String nameEncyclopedia;
	@JsonProperty("Content")
	private String content;
	@JsonProperty("AttributeName")
	private String attributeName;
	@JsonProperty("AttributeId")
	private long attributeId;
	
	public String getNameEncyclopedia() {
		return nameEncyclopedia;
	}
	public void setNameEncyclopedia(String nameEncyclopedia) {
		this.nameEncyclopedia = nameEncyclopedia;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	public long getAttributeId() {
		return attributeId;
	}
	public void setAttributeId(long attributeId) {
		this.attributeId = attributeId;
	}
	
}
