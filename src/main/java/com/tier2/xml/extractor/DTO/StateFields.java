package com.tier2.xml.extractor.DTO;

import com.tier2.xml.extractor.implementation.Tier2DTOImpl;
import com.tier2.xml.extractor.interfaces.Tier2DTO;
import com.tier2.xml.extractor.interfaces.Tier2DTOSimilarity;
import com.tier2.xml.extractor.singleton.EpcraTier2DatasetDiff;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.*;
import java.util.stream.Collectors;

public class StateFields implements Tier2DTO<StateFields> {
	private List<StateField> StateField;

	@XmlElement(name = "stateField")
	public List<StateField> getStateField() { 
		 return this.StateField; } 
	public void setStateField(List<StateField> StateField) { 
		 this.StateField = StateField; }

	@Override
	public boolean compareDTO(StateFields Dto) {
		int count = 0;
		boolean isEqual = true;
		Tier2DTOSimilarity<StateField> tier2DTO = new Tier2DTOImpl<>();
		EpcraTier2DatasetDiff epcraTier2DatasetDiff = EpcraTier2DatasetDiff.getInstance();

		Set<String> tier2ids = new HashSet<>();
		Set<String> eplanids = new HashSet<>();
		Map<String, StateField> tier2ContainsEplanids = new HashMap<>();
		List<String> tier2MissingEplanids = new ArrayList<>();
		List<String> tier2AdditionalEplanids = new ArrayList<>();

		for(StateField stateField : this.StateField)
			tier2ids.add(stateField.getT2sFieldname());
		for(StateField stateField : Dto.StateField)
		{
			if(tier2ids.contains(stateField.getT2sFieldname()))
			{
				tier2ContainsEplanids.put(stateField.getT2sFieldname(), stateField);
			}
			else
			{
				tier2MissingEplanids.add(stateField.getT2sFieldname());
			}
			eplanids.add(stateField.getT2sFieldname());
		}

		for(StateField stateField : this.StateField)
		{
			if(tier2ContainsEplanids.containsKey(stateField.getT2sFieldname())){
				count++;
				isEqual = isEqual && stateField.compareDTO(tier2ContainsEplanids.get(stateField.getT2sFieldname()));
			}
			else {
				tier2AdditionalEplanids.add(stateField.getT2sFieldname());
			}
		}

		//Add Missing and additional values to output
		String missingValues = tier2MissingEplanids.stream()
				.collect(Collectors.joining(", "));
		String additionalValues = tier2AdditionalEplanids.stream()
				.collect(Collectors.joining(", "));

		if(!missingValues.isEmpty())
			epcraTier2DatasetDiff.addDifferences("<"+this.getClass().getSimpleName()+"> "+"tier2 doesn't have T2sFieldnames: "+missingValues);
		if(!additionalValues.isEmpty())
			epcraTier2DatasetDiff.addDifferences("<"+this.getClass().getSimpleName()+"> "+"tier2 have additional T2sFieldnames: "+ additionalValues);

//		for(StateField thisStateField: this.getStateField()){
//			for(StateField stateField: Dto.getStateField()){
//				if(Objects.equals(thisStateField.getT2sFieldname(), stateField.getT2sFieldname())){
//					count++;
//					isEqual = isEqual && tier2DTO.checkDTOIsSimilar(thisStateField, stateField);
//				}
//			}
//		}
		if(this.getStateField().size() != Dto.getStateField().size() || count != Dto.getStateField().size() )
			return false;
		return isEqual;
	}
}