package com.tier2.xml.extractor.DTO;

import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

public class Hazards {
	private List<Hazard> Hazard;

	@XmlElement(name = "hazard")
	public List<Hazard> getHazard() {
		 return this.Hazard; } 
	public void setHazard(List<Hazard> Hazard) { 
		 this.Hazard = Hazard; } 

}