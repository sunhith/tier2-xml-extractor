package com.tier2.xml.extractor.DTO;

import com.tier2.xml.extractor.adapter.DateAdapter;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.Date;

@XmlType(propOrder = {"firstName","lastName","title","email","mailingAddress",
		"contactTypes","phones","lastModified"})
public class Contact {
	private String FirstName;
	private String LastName;
	private String Title;
	private String Email;
	private MailingAddress MailingAddress;
	private ContactTypes ContactTypes;
	private Phones Phones;
	private Date LastModified;
	private String Recordid;

	@XmlElement(name = "firstName")
	public String getFirstName() { 
		 return this.FirstName; } 
	public void setFirstName(String FirstName) { 
		 this.FirstName = FirstName; }

	@XmlElement(name = "lastName")
	public String getLastName() { 
		 return this.LastName; } 
	public void setLastName(String LastName) { 
		 this.LastName = LastName; }

	@XmlElement(name = "title")
	public String getTitle() { 
		 return this.Title; } 
	public void setTitle(String Title) { 
		 this.Title = Title; }

	@XmlElement(name = "email")
	public String getEmail() { 
		 return this.Email; } 
	public void setEmail(String Email) { 
		 this.Email = Email; }

	@XmlElement(name = "mailingAddress")
	public MailingAddress getMailingAddress() {
		 return this.MailingAddress; }
	public void setMailingAddress(MailingAddress MailingAddress) {
		 this.MailingAddress = MailingAddress; }

	@XmlElement(name = "contactTypes")
	public ContactTypes getContactTypes() {
		 return this.ContactTypes; }
	public void setContactTypes(ContactTypes ContactTypes) {
		 this.ContactTypes = ContactTypes; }

	@XmlElement(name = "phones")
	public Phones getPhones() {
		 return this.Phones; }
	public void setPhones(Phones Phones) {
		 this.Phones = Phones; }

	@XmlElement(name = "lastModified")
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date getLastModified() { 
		 return this.LastModified; } 
	public void setLastModified(Date LastModified) { 
		 this.LastModified = LastModified; }

	@XmlAttribute(name = "recordid")
	public String getRecordid() { 
		 return this.Recordid; } 
	public void setRecordid(String Recordid) { 
		 this.Recordid = Recordid; }
}