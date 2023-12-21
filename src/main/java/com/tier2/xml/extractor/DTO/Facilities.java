package com.tier2.xml.extractor.DTO;

import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

public class Facilities {
	private List<Facility> Facility;

	@XmlElement(name = "facility")
	public List<Facility> getFacility() {
		 return this.Facility; } 
	public void setFacility(List<Facility> Facility) {
		 this.Facility = Facility; } 

}