package com.tier2.xml.extractor.DTO;

import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

public class ContactIds {
	private List<ContactId> ContactId;

	@XmlElement(name = "contactId")
	public List<ContactId> getContactId() {
		 return this.ContactId; } 
	public void setContactId(List<ContactId> ContactId) {
		 this.ContactId = ContactId; } 

}