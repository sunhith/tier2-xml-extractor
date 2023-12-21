package com.tier2.xml.extractor.DTO;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"street","city","state","zipcode","country"})
public class MailingAddress {
	String Street;
	String City;
	String State;
	String Zipcode;
	String Country;

	@XmlElement(name = "street")
	public String getStreet() {
		 return this.Street; } 
	public void setStreet(String Street) {
		 this.Street = Street; }

	@XmlElement(name = "city")
	public String getCity() {
		 return this.City; } 
	public void setCity(String City) {
		 this.City = City; }

	@XmlElement(name = "state")
	public String getState() {
		 return this.State; } 
	public void setState(String State) {
		 this.State = State; }

	@XmlElement(name = "zipcode")
	public String getZipcode() {
		 return this.Zipcode; } 
	public void setZipcode(String Zipcode) {
		 this.Zipcode = Zipcode; }

	@XmlElement(name = "country")
	public String getCountry() {
		 return this.Country; } 
	public void setCountry(String Country) {
		 this.Country = Country; }

}