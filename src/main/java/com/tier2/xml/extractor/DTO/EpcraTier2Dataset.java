package com.tier2.xml.extractor.DTO;

import com.tier2.xml.extractor.implementation.Tier2DTOImpl;
import com.tier2.xml.extractor.interfaces.Tier2DTO;
import com.tier2.xml.extractor.interfaces.Tier2DTOSimilarity;
import com.tier2.xml.extractor.singleton.EpcraTier2DatasetDiff;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.lang.reflect.Field;
import java.util.Objects;

@XmlRootElement
public class EpcraTier2Dataset implements Tier2DTO<EpcraTier2Dataset> {
	private Dataset Dataset;
	private String Version;
	private String Xmlns;

	@XmlElement(name = "dataset")
	public Dataset getDataset() {
		 return this.Dataset; } 
	public void setDataset(Dataset Dataset) { 
		 this.Dataset = Dataset; }

	@XmlAttribute(name = "xmlns")
	public String getXmlns() { 
		 return this.Xmlns; }

	public void setXmlns(String Xmlns) { 
		 this.Xmlns = Xmlns!= null ? Xmlns.trim() : null; }

	@XmlAttribute(name = "version")
	public String getVersion() { 
		 return this.Version; } 
	public void setVersion(String Version) { 
		 this.Version = Version!= null ? Version.trim() : null; }


	public int compareTo(EpcraTier2Dataset o) {
		return this.Dataset.compareTo(o.Dataset);
	}

//	@Override
	public boolean checkDTOIsSimilar(EpcraTier2Dataset Dto) {
		boolean isequal = true;
		EpcraTier2DatasetDiff epcraTier2DatasetDiff = EpcraTier2DatasetDiff.getInstance();
		Field[] properties = this.getClass().getDeclaredFields();
		for (Field field: properties)
		{
			try {
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
	public boolean compareDTO(EpcraTier2Dataset Dto) {
		Tier2DTOSimilarity<EpcraTier2Dataset> tier2DTO = new Tier2DTOImpl<>();
		return tier2DTO.checkDTOIsSimilar(this, Dto);
	}
}