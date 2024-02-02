package com.tier2.xml.extractor.DTO;

import com.tier2.xml.extractor.implementation.Tier2DTOImpl;
import com.tier2.xml.extractor.interfaces.Tier2DTO;
import com.tier2.xml.extractor.interfaces.Tier2DTOSimilarity;
import com.tier2.xml.extractor.singleton.EpcraTier2DatasetDiff;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.*;
import java.util.stream.Collectors;

public class FacilityIds implements Tier2DTO<FacilityIds> {
	private List<FacilityId> FacilityId;

	@XmlElement(name = "facilityId")
	public List<FacilityId> getFacilityId() {
		 return this.FacilityId; } 
	public void setFacilityId(List<FacilityId> FacilityId) { 
		 this.FacilityId = FacilityId; }

	@Override
	public boolean compareDTO(FacilityIds Dto) {
		int count = 0;
		boolean isEqual = true;
		Tier2DTOSimilarity<FacilityId> tier2DTO = new Tier2DTOImpl<>();
		EpcraTier2DatasetDiff epcraTier2DatasetDiff = EpcraTier2DatasetDiff.getInstance();

		Set<String> tier2ids = new HashSet<>();
		Set<String> eplanids = new HashSet<>();
		Map<String, FacilityId> tier2ContainsEplanids = new HashMap<>();
		List<String> tier2MissingEplanids = new ArrayList<>();
		List<String> tier2AdditionalEplanids = new ArrayList<>();

		for(FacilityId facilityId : this.FacilityId)
			tier2ids.add(facilityId.getId());
		for(FacilityId facilityId : Dto.FacilityId)
		{
			if(tier2ids.contains(facilityId.getId()))
			{
				tier2ContainsEplanids.put(facilityId.getId(), facilityId);
			}
			else
			{
				tier2MissingEplanids.add(facilityId.getId());
			}
			eplanids.add(facilityId.getId());
		}

		for(FacilityId facilityId : this.FacilityId)
		{
			if(tier2ContainsEplanids.containsKey(facilityId.getId())){
				count++;
				isEqual = isEqual && facilityId.compareDTO(tier2ContainsEplanids.get(facilityId.getId()));
			}
			else {
				tier2AdditionalEplanids.add(facilityId.getId());
			}
		}

		//Add Missing and additional values to output
		String missingValues = tier2MissingEplanids.stream()
				.collect(Collectors.joining(", "));
		String additionalValues = tier2AdditionalEplanids.stream()
				.collect(Collectors.joining(", "));

		if(!missingValues.isEmpty())
			epcraTier2DatasetDiff.addDifferences("<"+this.getClass().getSimpleName()+"> "+"tier2 doesn't have FacilityIds: "+missingValues);
		if(!additionalValues.isEmpty())
			epcraTier2DatasetDiff.addDifferences("<"+this.getClass().getSimpleName()+"> "+"tier2 have additional FacilityIds: "+ additionalValues);

//		for(FacilityId thisFacilityId: this.getFacilityId()){
//			for(FacilityId facilityId: Dto.getFacilityId()){
//				if(Objects.equals(thisFacilityId.getId(), facilityId.getId())){
//					count++;
//					isEqual = isEqual && tier2DTO.checkDTOIsSimilar(thisFacilityId, facilityId);
//				}
//			}
//		}
		if(this.getFacilityId().size() != Dto.getFacilityId().size() || count != Dto.getFacilityId().size() )
			return false;
		return isEqual;
	}
}