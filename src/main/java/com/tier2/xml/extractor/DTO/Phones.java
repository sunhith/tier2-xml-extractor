package com.tier2.xml.extractor.DTO;

import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

public class Phones {
	List<Phone> Phone;

	@XmlElement(name = "phone")
	public List<Phone> getPhone() { 
		 return this.Phone; } 
	public void setPhone(List<Phone> Phone) { 
		 this.Phone = Phone; } 

}