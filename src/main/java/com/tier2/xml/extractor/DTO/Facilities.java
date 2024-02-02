package com.tier2.xml.extractor.DTO;

import com.tier2.xml.extractor.interfaces.Tier2DTO;
import com.tier2.xml.extractor.singleton.EpcraTier2DatasetDiff;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.*;
import java.util.stream.Collectors;

public class Facilities implements Tier2DTO<Facilities> {
	private List<Facility> Facility;

	@XmlElement(name = "facility")
	public List<Facility> getFacility() {
		return this.Facility;
	}

	public void setFacility(List<Facility> Facility) {
		this.Facility = Facility;
	}

//	@Override
	public int compareTo(Facilities o) {
		int isequal = 1; // 1 implies not equal, 0 => equal
		EpcraTier2DatasetDiff epcraTier2DatasetDiff = EpcraTier2DatasetDiff.getInstance();
		for (Facility facility : this.Facility)
			for (Facility fac : o.Facility) {
				if (facility.getFacilityName() != null
						&& fac.getFacilityName() != null
						&& facility.getFacilityName().equals(fac.getFacilityName()))
				{
					isequal = facility.compareTo(fac);
					break;
				}
			}
		return isequal;
	}

	@Override
	public boolean compareDTO(Facilities Dto) {
		int count = 0;
		boolean isEqual = true;
		EpcraTier2DatasetDiff epcraTier2DatasetDiff = EpcraTier2DatasetDiff.getInstance();

		Set<String> tier2ids = new HashSet<>();
		Set<String> eplanids = new HashSet<>();
		Map<String, Facility> tier2ContainsEplanids = new HashMap<>();
		List<String> tier2MissingEplanids = new ArrayList<>();
		List<String> tier2AdditionalEplanids = new ArrayList<>();

		for(Facility facility : this.Facility)
			tier2ids.add(facility.getFacilityName());
		for(Facility facility : Dto.Facility)
		{
			if(tier2ids.contains(facility.getFacilityName()))
			{
				tier2ContainsEplanids.put(facility.getFacilityName(), facility);
			}
			else
			{
				tier2MissingEplanids.add(facility.getFacilityName());
			}
			eplanids.add(facility.getFacilityName());
		}

		for(Facility facility : this.Facility)
		{
			if(tier2ContainsEplanids.containsKey(facility.getFacilityName())){
				count++;
				isEqual = isEqual && facility.compareDTO(tier2ContainsEplanids.get(facility.getFacilityName()));
			}
			else {
				tier2AdditionalEplanids.add(facility.getFacilityName());
			}
		}

		//Add Missing and additional values to output
		String missingValues = tier2MissingEplanids.stream()
				.collect(Collectors.joining(", "));
		String additionalValues = tier2AdditionalEplanids.stream()
				.collect(Collectors.joining(", "));

		if(!missingValues.isEmpty())
			epcraTier2DatasetDiff.addDifferences("<"+this.getClass().getSimpleName()+"> "+"tier2 doesn't have facility names:" + missingValues);
		if(!additionalValues.isEmpty())
			epcraTier2DatasetDiff.addDifferences("<"+this.getClass().getSimpleName()+"> "+"tier2 have additional facility names: "+ additionalValues);


//		for (Facility facility : this.Facility)
//			for (Facility fac : Dto.Facility) {
//				if (facility.getFacilityName() != null
//						&& fac.getFacilityName() != null
//						&& facility.getFacilityName().equals(fac.getFacilityName()))
//				{
//					count++;
//					isEqual = isEqual && facility.compareDTO(fac);
//					break;
//				}
//			}
		if(this.getFacility().size() != Dto.getFacility().size() || count != Dto.getFacility().size() )
			return false;
		return isEqual;
	}
}