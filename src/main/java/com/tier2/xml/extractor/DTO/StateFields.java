package com.tier2.xml.extractor.DTO;

import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

public class StateFields {
	List<StateField> StateField;

	@XmlElement(name = "stateField")
	public List<StateField> getStateField() { 
		 return this.StateField; } 
	public void setStateField(List<StateField> StateField) { 
		 this.StateField = StateField; }
}