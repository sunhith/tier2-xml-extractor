package com.tier2.xml.extractor.DTO;

import com.tier2.xml.extractor.implementation.Tier2DTOImpl;
import com.tier2.xml.extractor.interfaces.Tier2DTO;
import com.tier2.xml.extractor.interfaces.Tier2DTOSimilarity;
import com.tier2.xml.extractor.singleton.EpcraTier2DatasetDiff;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.*;
import java.util.stream.Collectors;

public class ContactIds implements Tier2DTO<ContactIds> {
	private List<ContactId> ContactId;

	@XmlElement(name = "contactId")
	public List<ContactId> getContactId() {
		 return this.ContactId; } 
	public void setContactId(List<ContactId> ContactId) {
		 this.ContactId = ContactId; }

	@Override
	public boolean compareDTO(ContactIds Dto)
	{
		int count = 0;
		boolean isEqual = true;
		Tier2DTOSimilarity<ContactId> tier2DTO = new Tier2DTOImpl<>();

		EpcraTier2DatasetDiff epcraTier2DatasetDiff = EpcraTier2DatasetDiff.getInstance();

		Set<String> tier2ids = new HashSet<>();
		Set<String> eplanids = new HashSet<>();
		Map<String, ContactId> tier2ContainsEplanids = new HashMap<>();
		List<String> tier2MissingEplanids = new ArrayList<>();
		List<String> tier2AdditionalEplanids = new ArrayList<>();

		for(ContactId contactId : this.ContactId)
			tier2ids.add(contactId.getLinkId());
		for(ContactId contactId : Dto.ContactId)
		{
			if(tier2ids.contains(contactId.getLinkId()))
			{
				tier2ContainsEplanids.put(contactId.getLinkId(), contactId);
			}
			else
			{
				tier2MissingEplanids.add(contactId.getLinkId());
			}
			eplanids.add(contactId.getLinkId());
		}

		for(ContactId contactId : this.ContactId)
		{
			if(tier2ContainsEplanids.containsKey(contactId.getLinkId())){
				count++;
				isEqual = isEqual && contactId.compareDTO(tier2ContainsEplanids.get(contactId.getLinkId()));
			}
			else {
				tier2AdditionalEplanids.add(contactId.getLinkId());
			}
		}

		//Add Missing and additional values to output
		String missingValues = tier2MissingEplanids.stream()
				.collect(Collectors.joining(", "));
		String additionalValues = tier2AdditionalEplanids.stream()
				.collect(Collectors.joining(", "));

		if(!missingValues.isEmpty())
			epcraTier2DatasetDiff.addDifferences("<"+this.getClass().getSimpleName()+"> "+"tier2 doesn't have linkid: "+missingValues);
		if(!additionalValues.isEmpty())
			epcraTier2DatasetDiff.addDifferences("<"+this.getClass().getSimpleName()+"> "+"tier2 have additional linkid: "+ additionalValues);

//		for(ContactId thisContactid: this.getContactId()){
//			for(ContactId contactId: Dto.getContactId()){
//				if(Objects.equals(thisContactid.getLinkId(), contactId.getLinkId())){
//					count++;
//					isEqual = isEqual && tier2DTO.checkDTOIsSimilar(thisContactid, contactId);
//				}
//			}
//		}
		if(this.getContactId().size() != Dto.getContactId().size() || count != Dto.getContactId().size() )
			return false;
		return isEqual;
	}
}