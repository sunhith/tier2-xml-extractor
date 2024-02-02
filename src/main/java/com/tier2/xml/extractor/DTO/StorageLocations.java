package com.tier2.xml.extractor.DTO;

import com.tier2.xml.extractor.implementation.Tier2DTOImpl;
import com.tier2.xml.extractor.interfaces.Tier2DTO;
import com.tier2.xml.extractor.interfaces.Tier2DTOSimilarity;
import com.tier2.xml.extractor.singleton.EpcraTier2DatasetDiff;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.*;
import java.util.stream.Collectors;

public class StorageLocations implements Tier2DTO<StorageLocations> {
	private List<StorageLocation> StorageLocation;

	@XmlElement(name = "storageLocation")
	public List<StorageLocation> getStorageLocation() {
		 return this.StorageLocation; }
	public void setStorageLocation(List<StorageLocation> StorageLocation) {
		 this.StorageLocation = StorageLocation; }

	@Override
	public boolean compareDTO(StorageLocations Dto) {
		int count = 0;
		boolean isEqual = true;
		Tier2DTOSimilarity<StorageLocation> tier2DTO = new Tier2DTOImpl<>();
		EpcraTier2DatasetDiff epcraTier2DatasetDiff = EpcraTier2DatasetDiff.getInstance();

		Set<String> tier2ids = new HashSet<>();
		Set<String> eplanids = new HashSet<>();
		Map<String, StorageLocation> tier2ContainsEplanids = new HashMap<>();
		List<String> tier2MissingEplanids = new ArrayList<>();
		List<String> tier2AdditionalEplanids = new ArrayList<>();

		for(StorageLocation storageLocation : this.StorageLocation)
			tier2ids.add(storageLocation.getLocationDescription());
		for(StorageLocation storageLocation : Dto.StorageLocation)
		{
			if(tier2ids.contains(storageLocation.getLocationDescription()))
			{
				tier2ContainsEplanids.put(storageLocation.getLocationDescription(), storageLocation);
			}
			else
			{
				tier2MissingEplanids.add(storageLocation.getLocationDescription());
			}
			eplanids.add(storageLocation.getLocationDescription());
		}

		for(StorageLocation storageLocation : this.StorageLocation)
		{
			if(tier2ContainsEplanids.containsKey(storageLocation.getLocationDescription())){
				count++;
				isEqual = isEqual && storageLocation.compareDTO(tier2ContainsEplanids.get(storageLocation.getLocationDescription()));
			}
			else {
				tier2AdditionalEplanids.add(storageLocation.getLocationDescription());
			}
		}

		//Add Missing and additional values to output
		String missingValues = tier2MissingEplanids.stream()
				.collect(Collectors.joining(", "));
		String additionalValues = tier2AdditionalEplanids.stream()
				.collect(Collectors.joining(", "));

		if(!missingValues.isEmpty())
			epcraTier2DatasetDiff.addDifferences("<"+this.getClass().getSimpleName()+"> "+"tier2 doesn't have LocationDescriptions: "+missingValues);
		if(!additionalValues.isEmpty())
			epcraTier2DatasetDiff.addDifferences("<"+this.getClass().getSimpleName()+"> "+"tier2 have additional LocationDescriptions: "+ additionalValues);

//		for(StorageLocation thisStorageLocation: this.getStorageLocation()){
//			for(StorageLocation storageLocation: Dto.getStorageLocation()){
//				if(Objects.equals(thisStorageLocation.getLocationDescription(), storageLocation.getLocationDescription())){
//					count++;
//					isEqual = isEqual && tier2DTO.checkDTOIsSimilar(thisStorageLocation, storageLocation);
//				}
//			}
//		}
		if(this.getStorageLocation().size() != Dto.getStorageLocation().size() || count != Dto.getStorageLocation().size() )
			return false;
		return isEqual;
	}
}