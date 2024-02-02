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

@XmlType(propOrder = {"phoneNumber","phoneType"})
public class Phone implements Tier2DTO<Phone> {
	private String PhoneNumber;
	private String PhoneType;
	private String recordid;

	@XmlElement(name = "phoneNumber")
	public String getPhoneNumber() { 
		 return this.PhoneNumber; } 
	public void setPhoneNumber(String PhoneNumber) { 
		 this.PhoneNumber = PhoneNumber!= null ? PhoneNumber.trim() : null; }

	@XmlElement(name = "phoneType")
	public String getPhoneType() { 
		 return this.PhoneType; } 
	public void setPhoneType(String PhoneType) { 
		 this.PhoneType = PhoneType!= null ? PhoneType.trim() : null; }

	@XmlAttribute(name = "recordid")
	public String getRecordid() { 
		 return this.recordid; }
	public void setRecordid(String recordid) {
		 this.recordid = recordid!= null ? recordid.trim() : null; }

//	@Override
	public boolean checkDTOIsSimilar(Phone Dto) {
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
	public boolean compareDTO(Phone Dto) {
		Tier2DTOSimilarity<Phone> tier2DTO = new Tier2DTOImpl<>();
		return tier2DTO.checkDTOIsSimilar(this, Dto);
	}
}