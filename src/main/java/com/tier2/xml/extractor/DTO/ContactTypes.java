package com.tier2.xml.extractor.DTO;

import com.tier2.xml.extractor.implementation.Tier2DTOImpl;
import com.tier2.xml.extractor.interfaces.Tier2DTO;
import com.tier2.xml.extractor.interfaces.Tier2DTOSimilarity;
import com.tier2.xml.extractor.singleton.EpcraTier2DatasetDiff;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.*;
import java.util.stream.Collectors;

public class ContactTypes implements Tier2DTO<ContactTypes> {
	private List<String> ContactType;

	@XmlElement(name = "contactType")
	public List<String> getContactType() { 
		 return this.ContactType; } 
	public void setContactType(List<String> ContactType) { 
		 this.ContactType = ContactType; }

	@Override
	public boolean compareDTO(ContactTypes Dto) {
		int count = 0;
		boolean isEqual = true;
		Tier2DTOSimilarity<String> tier2DTO = new Tier2DTOImpl<>();
		EpcraTier2DatasetDiff epcraTier2DatasetDiff = EpcraTier2DatasetDiff.getInstance();

		Set<String> tier2ids = new HashSet<>();
		Set<String> eplanids = new HashSet<>();
		Map<String, String> tier2ContainsEplanids = new HashMap<>();
		List<String> tier2MissingEplanids = new ArrayList<>();
		List<String> tier2AdditionalEplanids = new ArrayList<>();

		for(String contactType : this.ContactType)
			tier2ids.add(contactType);
		for(String contactType : Dto.ContactType)
		{
			if(tier2ids.contains(contactType))
			{
				tier2ContainsEplanids.put(contactType, contactType);
			}
			else
			{
				tier2MissingEplanids.add(contactType);
			}
			eplanids.add(contactType);
		}

		for(String contactType : this.ContactType)
		{
			if(tier2ContainsEplanids.containsKey(contactType)){
				count++;
				//isEqual = isEqual && contactId.compareDTO(tier2ContainsEplanids.get(contactId.getLinkId()));
			}
			else {
				tier2AdditionalEplanids.add(contactType);
			}
		}

		//Add Missing and additional values to output
		String missingValues = tier2MissingEplanids.stream()
				.collect(Collectors.joining(", "));
		String additionalValues = tier2AdditionalEplanids.stream()
				.collect(Collectors.joining(", "));

		if(!missingValues.isEmpty())
			epcraTier2DatasetDiff.addDifferences("<"+this.getClass().getSimpleName()+"> "+"tier2 doesn't have contactTypes: "+missingValues);
		if(!additionalValues.isEmpty())
			epcraTier2DatasetDiff.addDifferences("<"+this.getClass().getSimpleName()+"> "+"tier2 have additional contactTypes: "+ additionalValues);

//		for(String thisContactType: this.getContactType()){
//			for(String contactType: Dto.getContactType()){
//				if(Objects.equals(thisContactType, contactType)){
//					count++;
////					isEqual = isEqual && tier2DTO.checkDTOIsSimilar(thisContactType, contactType);
//				}
//			}
//		}
		if(this.getContactType().size() != Dto.getContactType().size() || count != Dto.getContactType().size() )
			return false;
		return isEqual;
	}
}