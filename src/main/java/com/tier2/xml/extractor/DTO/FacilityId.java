package com.tier2.xml.extractor.DTO;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"id","description"})
public class FacilityId {
	String Id;
	String Recordid;
	String Type;
	String Description;

	@XmlElement(name = "id")
	public String getId() { 
		 return this.Id; } 
	public void setId(String Id) { 
		 this.Id = Id; }

	@XmlAttribute(name = "recordid")
	public String getRecordid() { 
		 return this.Recordid; } 
	public void setRecordid(String Recordid) { 
		 this.Recordid = Recordid; }

	@XmlAttribute(name = "type")
	public String getType() { 
		 return this.Type; } 
	public void setType(String Type) { 
		 this.Type = Type; }

	@XmlElement(name = "description")
	public String getDescription() { 
		 return this.Description; } 
	public void setDescription(String Description) { 
		 this.Description = Description; }
}
