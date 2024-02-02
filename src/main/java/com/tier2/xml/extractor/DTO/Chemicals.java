package com.tier2.xml.extractor.DTO;

import com.tier2.xml.extractor.implementation.Tier2DTOImpl;
import com.tier2.xml.extractor.interfaces.Tier2DTO;
import com.tier2.xml.extractor.interfaces.Tier2DTOSimilarity;
import com.tier2.xml.extractor.singleton.EpcraTier2DatasetDiff;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.*;
import java.util.stream.Collectors;

public class Chemicals implements Tier2DTO<Chemicals> {
	List<Chemical> Chemical;

	@XmlElement(name = "chemical")
	public List<Chemical> getChemical() {
		 return this.Chemical; } 
	public void setChemical(List<Chemical> Chemical) {
		 this.Chemical = Chemical; }

	@Override
	public boolean compareDTO(Chemicals Dto) {
		int count = 0;
		boolean isEqual = true;
		Tier2DTOSimilarity<Chemical> tier2DTO = new Tier2DTOImpl<>();

		EpcraTier2DatasetDiff epcraTier2DatasetDiff = EpcraTier2DatasetDiff.getInstance();

		Set<String> tier2ids = new HashSet<>();
		Set<String> eplanids = new HashSet<>();
		Map<String, Chemical> tier2ContainsEplanids = new HashMap<>();
		List<String> tier2MissingEplanids = new ArrayList<>();
		List<String> tier2AdditionalEplanids = new ArrayList<>();

		for(Chemical chemical : this.Chemical)
			tier2ids.add(chemical.getCasNumber());
		for(Chemical chemical : Dto.Chemical)
		{
			if(tier2ids.contains(chemical.getCasNumber()))
			{
				tier2ContainsEplanids.put(chemical.getCasNumber(), chemical);
			}
			else
			{
				tier2MissingEplanids.add(chemical.getCasNumber());
			}
			eplanids.add(chemical.getCasNumber());
		}

		for(Chemical chemical : this.Chemical)
		{
			if(tier2ContainsEplanids.containsKey(chemical.getCasNumber())){
				count++;
				isEqual = isEqual && chemical.compareDTO(tier2ContainsEplanids.get(chemical.getCasNumber()));
			}
			else {
				tier2AdditionalEplanids.add(chemical.getCasNumber());
			}
		}

		//Add Missing and additional values to output
		String missingValues = tier2MissingEplanids.stream()
				.collect(Collectors.joining(", "));
		String additionalValues = tier2AdditionalEplanids.stream()
				.collect(Collectors.joining(", "));

		if(!missingValues.isEmpty())
			epcraTier2DatasetDiff.addDifferences("<"+this.getClass().getSimpleName()+"> "+"tier2 doesn't have chemicals with CAS numbers: "+missingValues);
		if(!additionalValues.isEmpty())
			epcraTier2DatasetDiff.addDifferences("<"+this.getClass().getSimpleName()+"> "+"tier2 have additional chemicals with CAS numbers: "+ additionalValues);

//		for(Chemical thisChemical:this.getChemical()){
//			for(Chemical chemical:Dto.getChemical())
//			{
//				if(Objects.equals(thisChemical.getCasNumber() , chemical.getCasNumber()))
//				{
//					count++;
//					isEqual = isEqual && tier2DTO.checkDTOIsSimilar(thisChemical, chemical);
//				}
//			}
//		}

		if(this.getChemical().size() != Dto.getChemical().size() || count != Dto.getChemical().size())
			return false;
		return isEqual;
	}
}