package com.tier2.xml.extractor.DTO;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"latitude","longitude"})
public class LatLong {
	double Latitude;
	double Longitude;

	@XmlElement(name = "latitude")
	public double getLatitude() { 
		 return this.Latitude; } 
	public void setLatitude(double Latitude) { 
		 this.Latitude = Latitude; }

	@XmlElement(name = "longitude")
	public double getLongitude() { 
		 return this.Longitude; } 
	public void setLongitude(double Longitude) { 
		 this.Longitude = Longitude; } 

}