package com.tier2.xml.extractor.DTO;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;

public class Amount {
	String Unit;
	int Value;

	@XmlAttribute(name = "unit")
	public String getUnit() { 
		 return this.Unit; } 
	public void setUnit(String Unit) { 
		 this.Unit = Unit; }

	@XmlValue
	public int getText() { 
		 return this.Value; }
	public void setText(int Value) {
		 this.Value = Value; }
}