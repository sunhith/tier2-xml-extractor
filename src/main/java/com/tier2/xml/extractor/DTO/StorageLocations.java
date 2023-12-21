package com.tier2.xml.extractor.DTO;

import jakarta.xml.bind.annotation.XmlElement;

public class StorageLocations {
	private StorageLocation StorageLocation;

	@XmlElement(name = "storageLocation")
	public StorageLocation getStorageLocation() {
		 return this.StorageLocation; }
	public void setStorageLocation(StorageLocation StorageLocation) {
		 this.StorageLocation = StorageLocation; }

}