package com.tier2.xml.extractor.DTO;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"locationDescription","storageType","pressure",
		"temperature","amount"})
public class StorageLocation {
	private String LocationDescription;
	private String StorageType;
	private String Pressure;
	private String Temperature;
	private Amount Amount;
	private String Recordid;

	@XmlElement(name = "locationDescription")
	public String getLocationDescription() {
		 return this.LocationDescription; }
	public void setLocationDescription(String LocationDescription) {
		 this.LocationDescription = LocationDescription; }

	@XmlElement(name = "storageType")
	public String getStorageType() {
		 return this.StorageType; }
	public void setStorageType(String StorageType) {
		 this.StorageType = StorageType; }

	@XmlElement(name = "pressure")
	public String getPressure() {
		 return this.Pressure; }
	public void setPressure(String Pressure) {
		 this.Pressure = Pressure; }

	@XmlElement(name = "temperature")
	public String getTemperature() {
		 return this.Temperature; }
	public void setTemperature(String Temperature) {
		 this.Temperature = Temperature; }

	@XmlElement(name = "amount")
	public Amount getAmount() {
		 return this.Amount; }
	public void setAmount(Amount Amount) {
		 this.Amount = Amount; }

	@XmlAttribute(name = "recordid")
	public String getRecordid() {
		 return this.Recordid; }
	public void setRecordid(String Recordid) {
		 this.Recordid = Recordid; }
}