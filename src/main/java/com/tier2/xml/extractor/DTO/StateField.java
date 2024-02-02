package com.tier2.xml.extractor.DTO;

import com.tier2.xml.extractor.implementation.Tier2DTOImpl;
import com.tier2.xml.extractor.interfaces.Tier2DTO;
import com.tier2.xml.extractor.interfaces.Tier2DTOSimilarity;
import com.tier2.xml.extractor.singleton.EpcraTier2DatasetDiff;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Set;

@XmlType(propOrder = {"label","t2sFieldname","data"})
public class StateField implements Tier2DTO<StateField> {
	private String Label;
	private String T2sFieldname;
	private String Data;
	private boolean Required;

	@XmlElement(name = "label")
	public String getLabel() { 
		 return this.Label; } 
	public void setLabel(String Label) { 
		 this.Label = Label!= null ? Label.trim() : null; }

	@XmlElement(name = "t2sFieldname")
	public String getT2sFieldname() { 
		 return this.T2sFieldname; } 
	public void setT2sFieldname(String T2sFieldname) { 
		 this.T2sFieldname = T2sFieldname!= null ? T2sFieldname.trim() : null; }

	@XmlElement(name = "data")
	public String getData() {
		 return this.Data; } 
	public void setData(String Data) {
		 this.Data = Data!= null ? Data.trim() : null; }

	@XmlAttribute(name = "required")
	public boolean getRequired() { 
		 return this.Required; } 
	public void setRequired(boolean Required) { 
		 this.Required = Required; }

//	@Override
	public boolean checkDTOIsSimilar(StateField Dto) {
		boolean isequal = true;
		EpcraTier2DatasetDiff epcraTier2DatasetDiff = EpcraTier2DatasetDiff.getInstance();
		Set<String> ignoreProperties = epcraTier2DatasetDiff.getIgnoreProperties(this.getClass().getSimpleName());
		Field[] properties = this.getClass().getDeclaredFields();
		for (Field field: properties)
		{
			try {
				boolean ignore = ignoreProperties.contains(field.getName());
				if(ignore) continue;

				Object thisValue = field.get(this);
				Object otherValue = field.get(Dto);

				// Comparison logic based on field type
				if (field.getType().isPrimitive() || field.getType().equals(String.class)) {
					if (!Objects.equals(thisValue, otherValue)) {
						epcraTier2DatasetDiff.addDifferences("<"+this.getClass().getSimpleName()+">: "+field.getName()+" is not same");
						isequal = false;
					}
				} else if (thisValue != null && otherValue != null && thisValue instanceof Tier2DTOSimilarity) {
					// For non-primitive types that implement Comparable
					int comparisonResult = ((Comparable) thisValue).compareTo(otherValue);
					if (comparisonResult != 0) {
						epcraTier2DatasetDiff.addDifferences("<"+this.getClass().getSimpleName()+">: "+field.getName()+" is not same");
						isequal = false;
					}
				}
				//System.out.println(field.getName() +" "+field.get(this)+" : "+field.getType().getSimpleName());
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		}
		return isequal;
	}

	@Override
	public boolean compareDTO(StateField Dto) {
		Tier2DTOSimilarity<StateField> tier2DTO = new Tier2DTOImpl<>();
		return tier2DTO.checkDTOIsSimilar(this, Dto);
	}
}