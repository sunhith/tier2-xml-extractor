package com.tier2.xml.extractor.DTO;

import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

public class ContactTypes {
	private List<String> ContactType;

	@XmlElement(name = "contactType")
	public List<String> getContactType() { 
		 return this.ContactType; } 
	public void setContactType(List<String> ContactType) { 
		 this.ContactType = ContactType; }
}