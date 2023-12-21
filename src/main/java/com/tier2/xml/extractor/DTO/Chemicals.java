package com.tier2.xml.extractor.DTO;

import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

public class Chemicals {
	List<Chemical> Chemical;

	@XmlElement(name = "chemical")
	public List<Chemical> getChemical() {
		 return this.Chemical; } 
	public void setChemical(List<Chemical> Chemical) {
		 this.Chemical = Chemical; }

}