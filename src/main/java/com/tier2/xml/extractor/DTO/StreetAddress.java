package com.tier2.xml.extractor.DTO;

import com.tier2.xml.extractor.implementation.Tier2DTOImpl;
import com.tier2.xml.extractor.interfaces.Tier2DTO;
import com.tier2.xml.extractor.interfaces.Tier2DTOSimilarity;
import com.tier2.xml.extractor.singleton.EpcraTier2DatasetDiff;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Set;

@XmlType(propOrder = {"street","city","state",
		"zipcode"})
public class StreetAddress implements Tier2DTO<StreetAddress> {
	private String Street;
	private String City;
	private String State;
	private int Zipcode;

	@XmlElement(name = "street")
	public String getStreet() { 
		 return this.Street; } 
	public void setStreet(String Street) { 
		 this.Street = Street!= null ? Street.trim() : null; }

	@XmlElement(name = "city")
	public String getCity() { 
		 return this.City; } 
	public void setCity(String City) { 
		 this.City = City!= null ? City.trim() : null; }

	@XmlElement(name = "state")
	public String getState() { 
		 return this.State; } 
	public void setState(String State) { 
		 this.State = State!= null ? State.trim() : null; }

	@XmlElement(name = "zipcode")
	public int getZipcode() { 
		 return this.Zipcode; } 
	public void setZipcode(int Zipcode) { 
		 this.Zipcode = Zipcode; }

//	@Override
	public boolean checkDTOIsSimilar(StreetAddress Dto) {
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
				} else if (thisValue != null && otherValue != null && thisValue instanceof Tier2DTO) {
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
	public boolean compareDTO(StreetAddress Dto) {
		Tier2DTOSimilarity<StreetAddress> tier2DTO = new Tier2DTOImpl<>();
		return tier2DTO.checkDTOIsSimilar(this, Dto);
	}
}