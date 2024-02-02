package com.tier2.xml.extractor.DTO;

import com.tier2.xml.extractor.implementation.Tier2DTOImpl;
import com.tier2.xml.extractor.interfaces.Tier2DTO;
import com.tier2.xml.extractor.interfaces.Tier2DTOSimilarity;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;

public class Amount implements Tier2DTO<Amount> {
	String Unit;
	int Value;

	@XmlAttribute(name = "unit")
	public String getUnit() { 
		 return this.Unit; } 
	public void setUnit(String Unit) { 
		 this.Unit = Unit!= null ? Unit.trim() : null; }

	@XmlValue
	public int getValue() {
		 return this.Value; }
	public void setValue(int Value) {
		 this.Value = Value; }

	public boolean compareDTO(Amount Dto) {
		Tier2DTOSimilarity<Amount> tier2DTO = new Tier2DTOImpl<>();
		return tier2DTO.checkDTOIsSimilar(this, Dto);
	}
}