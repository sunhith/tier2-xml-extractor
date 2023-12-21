package com.tier2.xml.extractor.DTO;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlType(propOrder = {"facilities", "contacts", "reportyear"})
public class Dataset {
	private Facilities Facilities;
	private Contacts Contacts;
	private int Reportyear;

	@XmlElement(name = "facilities")
	public Facilities getFacilities() {
		 return this.Facilities; }
	public void setFacilities(Facilities Facilities) {
		 this.Facilities = Facilities; }

	@XmlElement(name = "contacts")
	public Contacts getContacts() {
		 return this.Contacts; }
	public void setContacts(Contacts Contacts) {
		 this.Contacts = Contacts; }

	@XmlAttribute(name = "reportyear")
	public int getReportyear() {
		 return this.Reportyear; }
	public void setReportyear(int Reportyear) {
		 this.Reportyear = Reportyear; }
}