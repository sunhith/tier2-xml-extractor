package com.tier2.xml.extractor.DTO;

import com.tier2.xml.extractor.adapter.DateAdapter;
import com.tier2.xml.extractor.singleton.EpcraTier2DatasetDiff;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@XmlType(propOrder = {"facilityName", "streetAddress",
		"mailingAddress", "county", "fireDistrict", "latLong",
		"department","notes","sitePlanAttached","siteCoordAbbrevAttached",
		"dikeDescriptionAttached","facilityInfoSameAsLastYear",
		"nameAndTitleOfCertifier", "dateSigned","feesTotal","manned","maxNumOccupants",
		"subjectToChemAccidentPrevention", "subjectToEmergencyPlanning", "stateFields",
		"lastModified", "contactIds","chemicals","facilityIds"})
public class Facility implements Comparable<Facility>{
	private String FacilityName;
	private StreetAddress StreetAddress;
	private MailingAddress MailingAddress;
	private String FireDistrict;
	private String County;
	private LatLong LatLong;
	private String Department;
	private String Notes;
	private boolean SitePlanAttached;
	private String NameAndTitleOfCertifier;
	private boolean SiteCoordAbbrevAttached;
	private boolean FacilityInfoSameAsLastYear;
	private boolean DikeDescriptionAttached;
	private Date DateSigned;
	private String FeesTotal;
	private boolean Manned;
	private int MaxNumOccupants;
	private boolean SubjectToChemAccidentPrevention;
	private boolean SubjectToEmergencyPlanning;
	private Date LastModified;
	private StateFields StateFields;
	private ContactIds ContactIds;
	private Chemicals Chemicals;
	private FacilityIds FacilityIds;
	private String Recordid;

	@XmlElement(name = "facilityName")
	public String getFacilityName() { 
		 return this.FacilityName; } 
	public void setFacilityName(String FacilityName) { 
		 this.FacilityName = FacilityName; }

	@XmlElement(name = "streetAddress")
	public StreetAddress getStreetAddress() {
		 return this.StreetAddress; }
	public void setStreetAddress(StreetAddress StreetAddress) {
		 this.StreetAddress = StreetAddress; }

	@XmlElement(name = "mailingAddress")
	public MailingAddress getMailingAddress() {
		 return this.MailingAddress; }
	public void setMailingAddress(MailingAddress MailingAddress) {
		 this.MailingAddress = MailingAddress; }

	@XmlElement(name = "county")
	public String getCounty() { 
		 return this.County; } 
	public void setCounty(String County) { 
		 this.County = County; }

	@XmlElement(name = "fireDistrict")
	public String getFireDistrict() {
		return this.FireDistrict;
	}

	public void setFireDistrict(String FireDistrict) {
		this.FireDistrict = FireDistrict;
	}

	@XmlElement(name = "latLong")
	public LatLong getLatLong() {
		 return this.LatLong; }
	public void setLatLong(LatLong LatLong) {
		 this.LatLong = LatLong; }

	@XmlElement(name = "department", nillable = true)
	public String getDepartment() {
		 return this.Department; } 
	public void setDepartment(String Department) {
		 this.Department = Department; }

	@XmlElement(name = "notes", nillable = true)
	public String getNotes() {
		 return this.Notes; } 
	public void setNotes(String Notes) {
		 this.Notes = Notes; }

	@XmlElement(name = "sitePlanAttached")
	public boolean getSitePlanAttached() { 
		 return this.SitePlanAttached; } 
	public void setSitePlanAttached(boolean SitePlanAttached) { 
		 this.SitePlanAttached = SitePlanAttached; }

	@XmlElement(name = "siteCoordAbbrevAttached")
	public boolean getSiteCoordAbbrevAttached() { 
		 return this.SiteCoordAbbrevAttached; } 
	public void setSiteCoordAbbrevAttached(boolean SiteCoordAbbrevAttached) { 
		 this.SiteCoordAbbrevAttached = SiteCoordAbbrevAttached; }

	@XmlElement(name = "dikeDescriptionAttached")
	public boolean getDikeDescriptionAttached() { 
		 return this.DikeDescriptionAttached; } 
	public void setDikeDescriptionAttached(boolean DikeDescriptionAttached) { 
		 this.DikeDescriptionAttached = DikeDescriptionAttached; }

	@XmlElement(name = "facilityInfoSameAsLastYear")
	public boolean getFacilityInfoSameAsLastYear() { 
		 return this.FacilityInfoSameAsLastYear; } 
	public void setFacilityInfoSameAsLastYear(boolean FacilityInfoSameAsLastYear) { 
		 this.FacilityInfoSameAsLastYear = FacilityInfoSameAsLastYear; }

	@XmlElement(name = "nameAndTitleOfCertifier")
	public String getNameAndTitleOfCertifier() { 
		 return this.NameAndTitleOfCertifier; } 
	public void setNameAndTitleOfCertifier(String NameAndTitleOfCertifier) { 
		 this.NameAndTitleOfCertifier = NameAndTitleOfCertifier; }

	@XmlElement(name = "dateSigned")
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date getDateSigned() {
		 return this.DateSigned; } 
	public void setDateSigned(Date DateSigned) { 
		 this.DateSigned = DateSigned; }

	@XmlElement(name = "feesTotal", nillable = true)
	public String getFeesTotal() {
		 return this.FeesTotal; } 
	public void setFeesTotal(String FeesTotal) {
		 this.FeesTotal = FeesTotal; }

	@XmlElement(name = "manned")
	public boolean getManned() { 
		 return this.Manned; } 
	public void setManned(boolean Manned) { 
		 this.Manned = Manned; }

	@XmlElement(name = "maxNumOccupants")
	public int getMaxNumOccupants() { 
		 return this.MaxNumOccupants; } 
	public void setMaxNumOccupants(int MaxNumOccupants) { 
		 this.MaxNumOccupants = MaxNumOccupants; }

	@XmlElement(name = "subjectToChemAccidentPrevention")
	public boolean getSubjectToChemAccidentPrevention() { 
		 return this.SubjectToChemAccidentPrevention; } 
	public void setSubjectToChemAccidentPrevention(boolean SubjectToChemAccidentPrevention) { 
		 this.SubjectToChemAccidentPrevention = SubjectToChemAccidentPrevention; }

	@XmlElement(name = "subjectToEmergencyPlanning")
	public boolean getSubjectToEmergencyPlanning() { 
		 return this.SubjectToEmergencyPlanning; } 
	public void setSubjectToEmergencyPlanning(boolean SubjectToEmergencyPlanning) { 
		 this.SubjectToEmergencyPlanning = SubjectToEmergencyPlanning; }

	@XmlElement(name = "stateFields")
	public StateFields getStateFields() {
		 return this.StateFields; }
	public void setStateFields(StateFields StateFields) {
		 this.StateFields = StateFields; }

	@XmlElement(name = "lastModified")
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date getLastModified() { 
		 return this.LastModified; } 
	public void setLastModified(Date LastModified) { 
		 this.LastModified = LastModified; }

	@XmlElement(name = "contactIds")
	public ContactIds getContactIds() {
		 return this.ContactIds; }
	public void setContactIds(ContactIds ContactIds) {
		 this.ContactIds = ContactIds; }

	@XmlElement(name = "chemicals")
	public Chemicals getChemicals() {
		 return this.Chemicals; }
	public void setChemicals(Chemicals Chemicals) {
		 this.Chemicals = Chemicals; }

	@XmlElement(name = "facilityIds")
	public FacilityIds getFacilityIds() {
		 return this.FacilityIds; }
	public void setFacilityIds(FacilityIds FacilityIds) {
		 this.FacilityIds = FacilityIds; }

	@XmlAttribute(name = "recordid")
	public String getRecordid() { 
		 return this.Recordid; } 
	public void setRecordid(String Recordid) { 
		 this.Recordid = Recordid; }

	@Override
	public int compareTo(Facility o) {
		int isequal = 0;
		EpcraTier2DatasetDiff epcraTier2DatasetDiff = EpcraTier2DatasetDiff.getInstance();
		if(!Objects.equals(this.FacilityName, o.FacilityName))
		{
			epcraTier2DatasetDiff.addDifferences("<Facility>: FacilityName is not same");
			isequal = 1;
		}
		if(!Objects.equals(this.County, o.County)){
			epcraTier2DatasetDiff.addDifferences("<Facility>: County is not same");
			isequal = 1;
		}
		if(!Objects.equals(this.FireDistrict, o.FireDistrict)){
			epcraTier2DatasetDiff.addDifferences("<Facility>: FireDistrict is not same");
			isequal = 1;
		}
		if(!Objects.equals(this.Department, o.Department)){
			epcraTier2DatasetDiff.addDifferences("<Facility>: Department is not same");
			isequal = 1;
		}
		if(!Objects.equals(this.Notes, o.Notes)){
			epcraTier2DatasetDiff.addDifferences("<Facility>: Notes is not same");
			isequal = 1;
		}
		if(this.SitePlanAttached != o.SitePlanAttached){
			epcraTier2DatasetDiff.addDifferences("<Facility>: SitePlanAttached is not same");
			isequal = 1;
		}
		if(this.SiteCoordAbbrevAttached != o.SiteCoordAbbrevAttached){
			epcraTier2DatasetDiff.addDifferences("<Facility>: SiteCoordAbbrevAttached is not same");
			isequal = 1;
		}
		if(this.DikeDescriptionAttached != o.DikeDescriptionAttached){
			epcraTier2DatasetDiff.addDifferences("<Facility>: DikeDescriptionAttached is not same");
			isequal = 1;
		}
		if(this.FacilityInfoSameAsLastYear != o.FacilityInfoSameAsLastYear){
			epcraTier2DatasetDiff.addDifferences("<Facility>: FacilityInfoSameAsLastYear is not same");
			isequal = 1;
		}
		if(!Objects.equals(this.NameAndTitleOfCertifier, o.NameAndTitleOfCertifier)){
			epcraTier2DatasetDiff.addDifferences("<Facility>: NameAndTitleOfCertifier is not same");
			isequal = 1;
		}

		if( !(Objects.equals(this.DateSigned, o.DateSigned) ||
				(this.DateSigned != null && o.DateSigned != null
						&& new SimpleDateFormat("yyyyMMdd").format(this.DateSigned)
						.equals(new SimpleDateFormat("yyyyMMdd").format(o.DateSigned)))))
		{
			epcraTier2DatasetDiff.addDifferences("<Facility>: DateSigned is not same");
			isequal = 1;
		}

		if(!Objects.equals(this.FeesTotal, o.FeesTotal)){
			epcraTier2DatasetDiff.addDifferences("<Facility>: FeesTotal is not same");
			isequal = 1;
		}

		if(this.Manned != o.Manned){
			epcraTier2DatasetDiff.addDifferences("<Facility>: Manned is not same");
			isequal = 1;
		}

		if(this.MaxNumOccupants != o.MaxNumOccupants){
			epcraTier2DatasetDiff.addDifferences("<Facility>: MaxNumOccupants is not same");
			isequal = 1;
		}

		if(this.SubjectToChemAccidentPrevention != o.SubjectToChemAccidentPrevention){
			epcraTier2DatasetDiff.addDifferences("<Facility>: SubjectToChemAccidentPrevention is not same");
			isequal = 1;
		}

		if(this.SubjectToEmergencyPlanning != o.SubjectToEmergencyPlanning){
			epcraTier2DatasetDiff.addDifferences("<Facility>: SubjectToEmergencyPlanning is not same");
			isequal = 1;
		}

		return isequal;
	}
}