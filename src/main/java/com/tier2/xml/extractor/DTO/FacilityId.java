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

@XmlType(propOrder = {"id","description"})
public class FacilityId implements Tier2DTO<FacilityId> {
	private String Id;
	private String recordid;
	private String Type;
	private String Description;

	@XmlElement(name = "id")
	public String getId() { 
		 return this.Id; } 
	public void setId(String Id) { 
		 this.Id = Id!= null ? Id.trim() : null; }

	@XmlAttribute(name = "recordid")
	public String getRecordid() { 
		 return this.recordid; }
	public void setRecordid(String Recordid) { 
		 this.recordid = Recordid!= null ? Recordid.trim() : null; }

	@XmlAttribute(name = "type")
	public String getType() { 
		 return this.Type; } 
	public void setType(String Type) { 
		 this.Type = Type!= null ? Type.trim() : null; }

	@XmlElement(name = "description")
	public String getDescription() { 
		 return this.Description; } 
	public void setDescription(String Description) { 
		 this.Description = Description!= null ? Description.trim() : null; }

//	@Override
	public boolean checkDTOIsSimilar(FacilityId Dto) {
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
	public boolean compareDTO(FacilityId Dto) {
		Tier2DTOSimilarity<FacilityId> tier2DTO = new Tier2DTOImpl<>();
		return tier2DTO.checkDTOIsSimilar(this, Dto);
	}
}
