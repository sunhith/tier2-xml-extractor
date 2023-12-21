package com.tier2.xml.extractor.DTO;

import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;
public class FacilityIds {
	List<FacilityId> FacilityId;

	@XmlElement(name = "facilityId")
	public List<FacilityId> getFacilityId() {
		 return this.FacilityId; } 
	public void setFacilityId(List<FacilityId> FacilityId) { 
		 this.FacilityId = FacilityId; }
}