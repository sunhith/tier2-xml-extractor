package com.tier2.xml.extractor.DTO;

import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

public class Contacts {
	private List<Contact> Contact;

	@XmlElement(name = "contact")
	public List<Contact> getContact() {
		 return this.Contact; } 
	public void setContact(List<Contact> Contact) {
		 this.Contact = Contact; }
}