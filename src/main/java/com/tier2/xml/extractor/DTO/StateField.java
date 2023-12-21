package com.tier2.xml.extractor.DTO;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"label","t2sFieldname","data"})
public class StateField {
	private String Label;
	private String T2sFieldname;
	private String Data;
	private boolean Required;

	@XmlElement(name = "label")
	public String getLabel() { 
		 return this.Label; } 
	public void setLabel(String Label) { 
		 this.Label = Label; }

	@XmlElement(name = "t2sFieldname")
	public String getT2sFieldname() { 
		 return this.T2sFieldname; } 
	public void setT2sFieldname(String T2sFieldname) { 
		 this.T2sFieldname = T2sFieldname; }

	@XmlElement(name = "data")
	public String getData() {
		 return this.Data; } 
	public void setData(String Data) {
		 this.Data = Data; }

	@XmlAttribute(name = "required")
	public boolean getRequired() { 
		 return this.Required; } 
	public void setRequired(boolean Required) { 
		 this.Required = Required; }
}