package com.tier2.xml.extractor.DTO;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"phoneNumber","phoneType"})
public class Phone {
	String PhoneNumber;
	String PhoneType;
	String Recordid;

	@XmlElement(name = "phoneNumber")
	public String getPhoneNumber() { 
		 return this.PhoneNumber; } 
	public void setPhoneNumber(String PhoneNumber) { 
		 this.PhoneNumber = PhoneNumber; }

	@XmlElement(name = "phoneType")
	public String getPhoneType() { 
		 return this.PhoneType; } 
	public void setPhoneType(String PhoneType) { 
		 this.PhoneType = PhoneType; }

	@XmlAttribute(name = "recordid")
	public String getRecordid() { 
		 return this.Recordid; } 
	public void setRecordid(String Recordid) { 
		 this.Recordid = Recordid; }
}