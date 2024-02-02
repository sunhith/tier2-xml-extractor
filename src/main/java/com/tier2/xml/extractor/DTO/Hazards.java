package com.tier2.xml.extractor.DTO;

import com.tier2.xml.extractor.implementation.Tier2DTOImpl;
import com.tier2.xml.extractor.interfaces.Tier2DTO;
import com.tier2.xml.extractor.interfaces.Tier2DTOSimilarity;
import com.tier2.xml.extractor.singleton.EpcraTier2DatasetDiff;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.*;
import java.util.stream.Collectors;

public class Hazards implements Tier2DTO<Hazards> {
	private List<Hazard> Hazard;

	@XmlElement(name = "hazard")
	public List<Hazard> getHazard() {
		 return this.Hazard; } 
	public void setHazard(List<Hazard> Hazard) { 
		 this.Hazard = Hazard; }

	@Override
	public boolean compareDTO(Hazards Dto) {
		int count = 0;
		boolean isEqual = true;
		Tier2DTOSimilarity<Hazard> tier2DTO = new Tier2DTOImpl<>();
		EpcraTier2DatasetDiff epcraTier2DatasetDiff = EpcraTier2DatasetDiff.getInstance();

		Set<String> tier2ids = new HashSet<>();
		Set<String> eplanids = new HashSet<>();
		Map<String, Hazard> tier2ContainsEplanids = new HashMap<>();
		List<String> tier2MissingEplanids = new ArrayList<>();
		List<String> tier2AdditionalEplanids = new ArrayList<>();

		for(Hazard hazard : this.Hazard)
			tier2ids.add(hazard.getCategory());
		for(Hazard hazard : Dto.Hazard)
		{
			if(tier2ids.contains(hazard.getCategory()))
			{
				tier2ContainsEplanids.put(hazard.getCategory(), hazard);
			}
			else
			{
				tier2MissingEplanids.add(hazard.getCategory());
			}
			eplanids.add(hazard.getCategory());
		}

		for(Hazard hazard : this.Hazard)
		{
			if(tier2ContainsEplanids.containsKey(hazard.getCategory())){
				count++;
				isEqual = isEqual && hazard.compareDTO(tier2ContainsEplanids.get(hazard.getCategory()));
			}
			else {
				tier2AdditionalEplanids.add(hazard.getCategory());
			}
		}

		//Add Missing and additional values to output
		String missingValues = tier2MissingEplanids.stream()
				.collect(Collectors.joining(", "));
		String additionalValues = tier2AdditionalEplanids.stream()
				.collect(Collectors.joining(", "));

		if(!missingValues.isEmpty())
			epcraTier2DatasetDiff.addDifferences("<"+this.getClass().getSimpleName()+"> "+"tier2 doesn't have Categorys: "+missingValues);
		if(!additionalValues.isEmpty())
			epcraTier2DatasetDiff.addDifferences("<"+this.getClass().getSimpleName()+"> "+"tier2 have additional Categorys: "+ additionalValues);

//		for(Hazard thisHazard: this.getHazard()){
//			for(Hazard hazard: Dto.getHazard()){
//				if(Objects.equals(thisHazard.getCategory(), hazard.getCategory())){
//					count++;
//					isEqual = isEqual && tier2DTO.checkDTOIsSimilar(thisHazard, hazard);
//				}
//			}
//		}
		if(this.getHazard().size() != Dto.getHazard().size() || count != Dto.getHazard().size() )
			return false;
		return isEqual;
	}
}