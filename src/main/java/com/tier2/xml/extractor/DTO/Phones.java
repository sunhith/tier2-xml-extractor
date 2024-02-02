package com.tier2.xml.extractor.DTO;

import com.tier2.xml.extractor.implementation.Tier2DTOImpl;
import com.tier2.xml.extractor.interfaces.Tier2DTO;
import com.tier2.xml.extractor.interfaces.Tier2DTOSimilarity;
import com.tier2.xml.extractor.singleton.EpcraTier2DatasetDiff;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.*;
import java.util.stream.Collectors;

public class Phones implements Tier2DTO<Phones> {
	List<Phone> Phone;

	@XmlElement(name = "phone")
	public List<Phone> getPhone() { 
		 return this.Phone; } 
	public void setPhone(List<Phone> Phone) { 
		 this.Phone = Phone; }

	@Override
	public boolean compareDTO(Phones Dto) {
		int count = 0;
		boolean  isEqual = true;
		Tier2DTOSimilarity<Phone> tier2DTO = new Tier2DTOImpl<>();
		EpcraTier2DatasetDiff epcraTier2DatasetDiff = EpcraTier2DatasetDiff.getInstance();

		Set<String> tier2ids = new HashSet<>();
		Set<String> eplanids = new HashSet<>();
		Map<String, Phone> tier2ContainsEplanids = new HashMap<>();
		List<String> tier2MissingEplanids = new ArrayList<>();
		List<String> tier2AdditionalEplanids = new ArrayList<>();

		for(Phone phone : this.Phone)
			tier2ids.add(phone.getPhoneNumber());
		for(Phone phone : Dto.Phone)
		{
			if(tier2ids.contains(phone.getPhoneNumber()))
			{
				tier2ContainsEplanids.put(phone.getPhoneNumber(), phone);
			}
			else
			{
				tier2MissingEplanids.add(phone.getPhoneNumber());
			}
			eplanids.add(phone.getPhoneNumber());
		}

		for(Phone phone : this.Phone)
		{
			if(tier2ContainsEplanids.containsKey(phone.getPhoneNumber())){
				count++;
				isEqual = isEqual && phone.compareDTO(tier2ContainsEplanids.get(phone.getPhoneNumber()));
			}
			else {
				tier2AdditionalEplanids.add(phone.getPhoneNumber());
			}
		}

		//Add Missing and additional values to output
		String missingValues = tier2MissingEplanids.stream()
				.collect(Collectors.joining(", "));
		String additionalValues = tier2AdditionalEplanids.stream()
				.collect(Collectors.joining(", "));

		if(!missingValues.isEmpty())
			epcraTier2DatasetDiff.addDifferences("<"+this.getClass().getSimpleName()+"> "+"tier2 doesn't have phone numbers: "+missingValues);
		if(!additionalValues.isEmpty())
			epcraTier2DatasetDiff.addDifferences("<"+this.getClass().getSimpleName()+"> "+"tier2 have additional phone numbers: "+ additionalValues);

//		for(Phone thisPhone: this.getPhone()){
//			for(Phone phone: Dto.getPhone()){
//				if(Objects.equals(thisPhone.getPhoneNumber(), phone.getPhoneNumber())){
//					count++;
//					isEqual = isEqual && tier2DTO.checkDTOIsSimilar(thisPhone, phone);
//				}
//			}
//		}
		if(this.getPhone().size() != Dto.getPhone().size() || count != Dto.getPhone().size() )
			return false;
		return isEqual;
	}
}