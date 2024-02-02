package com.tier2.xml.extractor.DTO;

import com.tier2.xml.extractor.implementation.Tier2DTOImpl;
import com.tier2.xml.extractor.interfaces.Tier2DTO;
import com.tier2.xml.extractor.interfaces.Tier2DTOSimilarity;
import com.tier2.xml.extractor.singleton.EpcraTier2DatasetDiff;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.*;
import java.util.stream.Collectors;

public class Contacts implements Tier2DTO<Contacts> {
	private List<Contact> Contact;

	@XmlElement(name = "contact")
	public List<Contact> getContact() {
		 return this.Contact; } 
	public void setContact(List<Contact> Contact) {
		 this.Contact = Contact; }

	@Override
	public boolean compareDTO(Contacts Dto) {
		int count = 0;
		boolean isEqual = true;
		Tier2DTOSimilarity<Contact> tier2DTO = new Tier2DTOImpl<>();
		EpcraTier2DatasetDiff epcraTier2DatasetDiff = EpcraTier2DatasetDiff.getInstance();

		Set<String> tier2ids = new HashSet<>();
		Set<String> eplanids = new HashSet<>();
		Map<String, Contact> tier2ContainsEplanids = new HashMap<>();
		List<String> tier2MissingEplanids = new ArrayList<>();
		List<String> tier2AdditionalEplanids = new ArrayList<>();

		for(Contact contact : this.Contact)
			tier2ids.add(contact.getFirstName()+" "+contact.getLastName());
		for(Contact contact : Dto.Contact)
		{
			if(tier2ids.contains(contact.getFirstName()+" "+contact.getLastName()))
			{
				tier2ContainsEplanids.put(contact.getFirstName()+" "+contact.getLastName(), contact);
			}
			else
			{
				tier2MissingEplanids.add(contact.getFirstName()+" "+contact.getLastName());
			}
			eplanids.add(contact.getFirstName()+" "+contact.getLastName());
		}

		for(Contact contact : this.Contact)
		{
			if(tier2ContainsEplanids.containsKey(contact.getFirstName()+" "+contact.getLastName())){
				count++;
				isEqual = isEqual && contact.compareDTO(tier2ContainsEplanids.get(contact.getFirstName()+" "+contact.getLastName()));
			}
			else {
				tier2AdditionalEplanids.add(contact.getFirstName()+" "+contact.getLastName());
			}
		}

		//Add Missing and additional values to output
		String missingValues = tier2MissingEplanids.stream()
				.collect(Collectors.joining(", "));
		String additionalValues = tier2AdditionalEplanids.stream()
				.collect(Collectors.joining(", "));

		if(!missingValues.isEmpty())
			epcraTier2DatasetDiff.addDifferences("<"+this.getClass().getSimpleName()+"> "+"tier2 doesn't have first and last names: "+missingValues);
		if(!additionalValues.isEmpty())
			epcraTier2DatasetDiff.addDifferences("<"+this.getClass().getSimpleName()+"> "+"tier2 have additional first and last names: "+ additionalValues);

//		for(Contact thisContact: this.getContact()){
//			for(Contact contact: Dto.getContact()){
//				if(Objects.equals(thisContact.getFirstName(), contact.getFirstName())){
//					count++;
//					isEqual = isEqual && tier2DTO.checkDTOIsSimilar(thisContact, contact);
//				}
//			}
//		}
		if(this.getContact().size() != Dto.getContact().size() || count != Dto.getContact().size() )
			return false;
		return isEqual;
	}
}