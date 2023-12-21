package com.tier2.xml.extractor.DTO;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"category","value"})
public class Hazard {
	private String Category;
	private boolean Value;

	@XmlElement(name = "category")
	public String getCategory() { 
		 return this.Category; } 
	public void setCategory(String Category) { 
		 this.Category = Category; }

	@XmlElement(name = "value")
	public boolean getValue() { 
		 return this.Value; } 
	public void setValue(boolean Value) { 
		 this.Value = Value; } 

}